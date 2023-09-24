package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        /*Foi usado o Generics pois caso futuramente teria que vazer vários métodos parecidos para diversas classe que possívelmente chegaria aqui
        Criamos a interface IconverteDados
         */
        try {
            return mapper.readValue(json, classe); //Ler esse json e tenta transformar na classe que a pessoa mandou
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
