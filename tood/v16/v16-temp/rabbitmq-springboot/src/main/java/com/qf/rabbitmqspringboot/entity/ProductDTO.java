package com.qf.rabbitmqspringboot.entity;

import java.io.Serializable;

/**
 * @author yucan
 * @Date 2019/8/15
 */
public class ProductDTO implements Serializable {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ProductDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductDTO(String s, String name) {
    }

    public void setName(String name) {
        this.name = name;
    }
}
