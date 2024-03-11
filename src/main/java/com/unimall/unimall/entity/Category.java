package com.unimall.unimall.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private Long parentId;
    @Column
    private int status;
   

    public Category(String name, Long parentId) {
        this.name = name;
        this.parentId = parentId;
       
        this.status = 1;

    }
   
    

    public Category() {

    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", parentId=" + parentId + ", status=" + status + "]";
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
   
}