package com.frre.labii.springbootproyect.com.frre.labii.springbootproyect.controller;

import com.frre.labii.springbootproyect.Alumno;
import org.springframework.web.bind.annotation.*;

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
    public String alumno(@RequestParam(value="legajo") String legajo , @RequestParam(value="nombre") String nombre,
                         @RequestParam(value="apellido") String apellido,@RequestParam(value="carrera")String carrera,
                         @RequestParam(value="cantMaterias")String cantMaterias) throws NoDataException{
        try{
            if((nombre.equals(""))||(apellido.equals(""))||legajo.equals("")||carrera.equals("")||cantMaterias.equals("")){
            throw new NoDataException("ExcepcionIncompleto : existen campos incompletos");
            }
            /* se parsea a int legajo y cantidad de materias */
            int leg = Integer.parseInt(legajo);
            int mat = Integer.parseInt(cantMaterias);

            Alumno alu = new Alumno(nombre, apellido, leg, carrera, mat);
            agregar(alu);

            return "agregado exitoso";
            /* alumno agregado */

        }catch(NoDataException e){
            return e.getMessage();
            /* retorno de excepcion */
        }
    }

    //modificar campos de un alumno especifico dado el legajo PUT method
    @RequestMapping(value="/{legajo}/", method = RequestMethod.PUT)
    public Alumno alumno(@PathVariable int legajo, @RequestParam(value="nombre",required=false) String nombre,
                         @RequestParam(value="apellido",required=false) String apellido,
                         @RequestParam(value="carrera",required=false)String carrera,
                         @RequestParam(value="cantMaterias",required=false)String cantMaterias){
        try {
            int pos = buscar(legajo);
            if(pos>=0){
                if (nombre == null && apellido == null && carrera == null && cantMaterias == null) {
                    return new Alumno("Existen campos incompletos");
                }
                if(nombre != null){
                    alumnos.get(pos).setNombre(nombre);
                }
                if(apellido != null){
                    alumnos.get(pos).setApellido(apellido);
                }
                if(carrera != null){
                    alumnos.get(pos).setCarrera(carrera);
                }
                if(cantMaterias != null){
                    int mat = Integer.parseInt(cantMaterias);
                    alumnos.get(pos).setCantMaterias(mat);
                }

                Alumno alum = alumnos.get(pos);

                String n=alum.getNombre();
                String a=alum.getApellido();
                String c=alum.getCarrera();
                int cm=alum.getCantMaterias();

                return new Alumno(n,a,legajo,c,cm);
            }else {
                throw new NoDataException("Legajo inexistente");
            }

        } catch (Exception e) {
            return new Alumno(e.getMessage());
        }
    }

    /* borrar alumno DELETE method */
    @RequestMapping(value="/borrar" , method = RequestMethod.DELETE)
    public String alumno(@RequestParam(value="legajo") int legajo){
        try {
            int pos=buscar(legajo);
            /* busqueda por legajo */

            if(pos>=0){
                alumnos.remove(pos);
                return "Alumno borrado";
                /* el alumno existe y se borro */
            }else {
                throw new NoDataException("Legajo inexistente");
            }

        } catch (NoDataException e) {
            return e.getMessage();
            /* catcheo el error si se presenta */
        }

    }

    /* metodo privado buscar */
    private int buscar(int legajo) {
        boolean esta = false;
        int i = 0;
        if (alumnos!= null){
            int t = alumnos.size();
            while (!esta && i < t){
                if (legajo == alumnos.get(i).getLegajo()) {
                    esta = true;
                    return i;
                }else {
                    i++;
                }
            }
        }
        return -1;
    }

    /* metodo privado agregar */
    private Alumno agregar(Alumno alu) {
        if (alumnos == null){
            alumnos = new LinkedList<Alumno>();
        }
        alumnos.add(alu);
        return alu;
    }
}
