package br.com.senac.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.api.frameWork.utils.ResponseUtil;
import br.com.senac.api.useCases.usuarios.UsuariosService;
import br.com.senac.api.useCases.usuarios.domains.UsuariosRequestDom;
import br.com.senac.api.useCases.usuarios.impl.UsuariosServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuariosService usuariosService;

    public UsuariosController(UsuariosServiceImpl usuariosServiceImpl) {
        this.usuariosService = usuariosServiceImpl;
    }

    @PostMapping("/")
    public ResponseEntity<?> criar(@RequestBody UsuariosRequestDom usuario) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.criar(usuario));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuariosRequestDom usuario) {
        try{
            return ResponseEntity.ok().body(usuariosService.login(usuario));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessage()));
        }
    }
}
