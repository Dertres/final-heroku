package org.unitec.finalheroku;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")//
public class ControladorMensajes {
    @Autowired RepositorioMensajito repoMensa;
    @RequestMapping(value="/mensajito",method=RequestMethod.GET,headers={"Accept=application/json"})
    public ArrayList<Mensajito> hola(){
            
        //Mensajito mensa=new Mensajito("Hola","No me asustan los temblores");
        return (ArrayList<Mensajito>)repoMensa.findAll();
    }
    @RequestMapping(value="/mensajito/{id}/{titulo}/{cuerpo}",method=RequestMethod.GET,headers={"Accept=application/json"})
    public Estatus guardar(@PathVariable String id,@PathVariable String titulo,@PathVariable String cuerpo){
    repoMensa.save(new Mensajito(id,titulo,cuerpo));
    return new Estatus (true,"Guardado correctamente");
    
    }
    
}

