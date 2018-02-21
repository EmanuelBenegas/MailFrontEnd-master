package com.Client.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Usuario on 19/02/2018.
 */
public class Mensaje {
    @JsonProperty
    private int id;

    @JsonProperty
    private String asunto;

    @JsonProperty
    private String mensage;

    @JsonProperty
    private  int id_usuario;

    @JsonProperty
    private List<User> receptores;

}
