package com.dam2.ejhibernate;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
public class toXML {
    public static void main(String[] args) throws ParserConfigurationException,TransformerException {
        Set<Profesor> profes = new HashSet<Profesor>();
        profes.add(new Profesor("Paco"));
        profes.add(new Profesor("Sandra"));
        Alumno a1 = new Alumno(1,"Luis",13,2);
        Asignatura s1 = new Asignatura(3,"Bases de datos",profes);
        Vector<Alumno> listaAlumnos = new Vector<Alumno>();
        listaAlumnos.add(a1);
        Vector<Asignatura> listaAsignaturas = new Vector<Asignatura>();
        listaAsignaturas.add(s1);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation dom = builder.getDOMImplementation();
        Document documento = dom.createDocument(null, "xml", null);
        Element raiz = documento.createElement("instituto");
        documento.getDocumentElement().appendChild(raiz);
        Element nodoInstituto = null , nodoDatos = null ;
        Text texto = null;

        for (Alumno student : listaAlumnos) {
            nodoInstituto = documento.createElement("Alumno");
            raiz.appendChild(nodoInstituto);
            nodoDatos = documento.createElement("cod");
            nodoInstituto.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(student.getCod()));
            nodoDatos.appendChild(texto);
            nodoDatos = documento.createElement("nombre");
            nodoInstituto.appendChild(nodoDatos);
            texto = documento.createTextNode(student.getNombre());
            nodoDatos.appendChild(texto);
            nodoDatos = documento.createElement("edad");
            nodoInstituto.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(student.getEdad()));
            nodoDatos.appendChild(texto);
            nodoDatos = documento.createElement("curso");
            nodoInstituto.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(student.getCurso()));
            nodoDatos.appendChild(texto);
        }
        for (Asignatura subject : listaAsignaturas) {
            nodoInstituto = documento.createElement("Asignatura");
            raiz.appendChild(nodoInstituto);
            nodoDatos = documento.createElement("cod");
            nodoInstituto.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(subject.getCod()));
            nodoDatos.appendChild(texto);
            nodoDatos = documento.createElement("nombre");
            nodoInstituto.appendChild(nodoDatos);
            texto = documento.createTextNode(subject.getNombre());
            nodoDatos.appendChild(texto);
            nodoDatos = documento.createElement("profesores");
            nodoInstituto.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(subject.getProfesores()));
            nodoDatos.appendChild(texto);
        }
        Source source = new DOMSource(documento);
        Result resultado = new StreamResult(new File("instituto.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        //transformer.transform(new StreamSource(source), new StreamResult(resultado));
        transformer.transform(source,resultado);
    }
}
