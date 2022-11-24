--
-- PostgreSQL database dump
--

-- Dumped from database version 11.13
-- Dumped by pg_dump version 11.13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: alumno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumno (
    cod integer NOT NULL,
    nombre character varying(255),
    edad integer,
    curso integer
);


ALTER TABLE public.alumno OWNER TO postgres;

--
-- Name: alumnos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumnos (
    cod integer,
    nombre character(20),
    edad integer,
    curso integer
);


ALTER TABLE public.alumnos OWNER TO postgres;

--
-- Name: asignatura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignatura (
    cod integer NOT NULL,
    nombre character varying(255),
    profesores integer
);


ALTER TABLE public.asignatura OWNER TO postgres;

--
-- Name: asignatura_profesores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignatura_profesores (
    id integer NOT NULL,
    elt integer NOT NULL
);


ALTER TABLE public.asignatura_profesores OWNER TO postgres;

--
-- Name: asignaturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignaturas (
    cod integer,
    nombre character(20),
    profesores integer
);


ALTER TABLE public.asignaturas OWNER TO postgres;

--
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    cod integer NOT NULL,
    nombre character varying(255),
    edad integer
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- Name: personas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personas (
    cod integer,
    nombre character(20),
    edad integer
);


ALTER TABLE public.personas OWNER TO postgres;

--
-- Name: profesor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesor (
    cod integer NOT NULL,
    nombre character varying(255),
    edad integer,
    tutor boolean
);


ALTER TABLE public.profesor OWNER TO postgres;

--
-- Name: profesores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesores (
    cod integer,
    nombre character(20),
    edad integer,
    tutor boolean
);


ALTER TABLE public.profesores OWNER TO postgres;

--
-- Name: profesores-asignaturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."profesores-asignaturas" (
    profesores integer,
    asignaturas integer
);


ALTER TABLE public."profesores-asignaturas" OWNER TO postgres;

--
-- Data for Name: alumno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumno (cod, nombre, edad, curso) FROM stdin;
\.


--
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumnos (cod, nombre, edad, curso) FROM stdin;
\.


--
-- Data for Name: asignatura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asignatura (cod, nombre, profesores) FROM stdin;
1	Entornos	\N
\.


--
-- Data for Name: asignatura_profesores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asignatura_profesores (id, elt) FROM stdin;
1	3
1	2
1	1
\.


--
-- Data for Name: asignaturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asignaturas (cod, nombre, profesores) FROM stdin;
\.


--
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (cod, nombre, edad) FROM stdin;
\.


--
-- Data for Name: personas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personas (cod, nombre, edad) FROM stdin;
\.


--
-- Data for Name: profesor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesor (cod, nombre, edad, tutor) FROM stdin;
3	Miguel	0	\N
2	David	0	\N
1	Ricardo	0	\N
\.


--
-- Data for Name: profesores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesores (cod, nombre, edad, tutor) FROM stdin;
\.


--
-- Data for Name: profesores-asignaturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."profesores-asignaturas" (profesores, asignaturas) FROM stdin;
\.


--
-- Name: alumno alumno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (cod);


--
-- Name: asignatura asignatura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT asignatura_pkey PRIMARY KEY (cod);


--
-- Name: asignatura_profesores asignatura_profesores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignatura_profesores
    ADD CONSTRAINT asignatura_profesores_pkey PRIMARY KEY (id, elt);


--
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (cod);


--
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (cod);


--
-- Name: asignatura_profesores fkhgk6oavj36dgn9iqsk3pj4j2x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignatura_profesores
    ADD CONSTRAINT fkhgk6oavj36dgn9iqsk3pj4j2x FOREIGN KEY (id) REFERENCES public.asignatura(cod);


--
-- Name: asignatura_profesores fkijse8dmicjijure3192i8s8mn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignatura_profesores
    ADD CONSTRAINT fkijse8dmicjijure3192i8s8mn FOREIGN KEY (elt) REFERENCES public.profesor(cod);


--
-- PostgreSQL database dump complete
--

