package com.ap.ap.services;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ap.ap.repository.IEducacionRepo;

@Service //declaracion del servicio
@Transactional //union con el controlador y control de metodos
public class EducacionService {

    private final IEducacionRepo educacionRepo;

    @Autowired
    public EducacionService(IEducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }

    //Se declara el CRUM
    public Educacion addEducacion(Educacion educacion) {
        return educacionRepo.save(educacion);
    }

    public List<Educacion> buscarEducacion() {
        return educacionRepo.findAll();
    }

    public Educacion editarEducacion(Educacion educacion) {
        return educacionRepo.save(educacion);
    }

    public void deleteEducacion(Long id) {
        educacionRepo.deleteById(id);
    }

    public Educacion buscaEducacionPorId(Long id) {
        return educacionRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Educacion no encontrada"));
    }
}
