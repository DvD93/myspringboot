package com.frre.labii.springbootproyect.com.frre.labii.springbootproyect.controller;

import com.frre.labii.springbootproyect.Alumno;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class Controller {
    /* lista alumnos */
    private static LinkedList<Alumno> alumnos;

    /* metodos POST GET DELTE PUT */

    /* listar alumnos GET method */
    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public LinkedList<Alumno>alumno() {
        if (alumnos==null) {
            LinkedList<Alumno> alu = new LinkedList<Alumno>();
            Alumno error = new Alumno("error lista vacia");
            alu.add(error);
            return alu;
        }
        return  alumnos;
    }

    /* agregar un alumno POST method */
    @RequestMapping(value="/agregar", method = RequestMethod.POST)
    public String alumno(@RequestParam(value="legajo") String legajo , @RequestParam(value="nombre") String nombre, @RequestParam(value="apellido") String apellido,
                           @RequestParam(value="carrera")String carrera, @RequestParam(value="cantMaterias")String cantMaterias) /*throws ExcepcionDatos */{
//        try{
//            //cambio a int los parametros numLeg y cantMat
//            if((nombre.equals(""))||(apellido.equals(""))||carrera.equals("")||cantMaterias.equals("")){
//                //throw new ExcepcionDatos("ExcepcionFaltanDatos : Es necesario completar todos los datos para crear un elemento nuevo");
//            }
//
//            int leg = Integer.parseInt(legajo);
//            int mat = Integer.parseInt(cantMaterias);
//            Alumno al = new Alumno(nombre, apellido, leg, carrera, mat);
//            //agregar(al);//agrega al alumno
//            return "agregado exitoso";//muestra msj q se agrego exitosamente
//        }catch(ExcepcionDatos e){
//            return e.getMessage();//si pasan un parametro nulo muestra respectiva exepcion
//        }
        //cambio a int los parametros numLeg y cantMat
        if((nombre.equals(""))||(apellido.equals(""))||carrera.equals("")||cantMaterias.equals("")){
            //throw new ExcepcionDatos("ExcepcionFaltanDatos : Es necesario completar todos los datos para crear un elemento nuevo");
        }

        int leg = Integer.parseInt(legajo);
        int mat = Integer.parseInt(cantMaterias);
        Alumno al = new Alumno(nombre, apellido, leg, carrera, mat);
        //agregar(al);//agrega al alumno
        return "agregado exitoso";//muestra msj q se agrego exitosamente
    }
}
