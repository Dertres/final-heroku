package org.unitec.finalheroku;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin //orígenes cruzados
@RequestMapping("/api")//
public class ControladorMensajes {
    
    @Autowired RepositorioMensajito repoMensa;
    
    
    //Buscar todo
    @CrossOrigin
    @RequestMapping(value="/mensajito",method=RequestMethod.GET,headers={"Accept=application/json"})
    public ArrayList<Mensajito> hola(){
        //Mensajito mensa=new Mensajito("Hola","No me asustan los temblores");
        return (ArrayList<Mensajito>)repoMensa.findAll();
    }
    
    
    //Buscar por ID
    @CrossOrigin
    @RequestMapping(value="/mensajito/{id}",method=RequestMethod.GET,headers={"Accept=application/json"})
    public Mensajito hola(@PathVariable String id){
        //Mensajito mensa=new Mensajito("Hola","No me asustan los temblores");
        return repoMensa.findOne(id);
    }
    
    
    //Actualizar
    @CrossOrigin
    @RequestMapping(value="/mensajito/{id}/{titulo}/{cuerpo}",method=RequestMethod.PUT,headers={"Accept=application/json"})
    public Estatus actualizar(@PathVariable String id,@PathVariable String titulo,@PathVariable String cuerpo){
    repoMensa.save(new Mensajito(id,titulo,cuerpo));
    return new Estatus (true,"Actualizado correctamente");
    
    }
    
    
    //Guardar
    @CrossOrigin
    @RequestMapping(value="/mensajito/{titulo}/{cuerpo}",method=RequestMethod.POST,headers={"Accept=application/json"})
    public Estatus guardar(@PathVariable String titulo,@PathVariable String cuerpo){
    repoMensa.save(new Mensajito(titulo,cuerpo));
    return new Estatus (true,"Guardado correctamente");
    
    }
    
    
    //Borrar
    @CrossOrigin
    @RequestMapping(value="/mensajito/{id}",method=RequestMethod.DELETE,headers={"Accept=application/json"})
    public Estatus borrarMensaje(@PathVariable String id){ 
    Estatus estatus=new Estatus(true, "Borrado con éxito");
    repoMensa.delete(new Mensajito(id));
    return estatus;
    
    }

            
  
    
}