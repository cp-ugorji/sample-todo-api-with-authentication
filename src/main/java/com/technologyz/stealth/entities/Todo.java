/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Chukwudi Ugorji
 */
@Entity
@Data
//@AllArgsConstructor
@EqualsAndHashCode
@ApiModel(description = "All details about a Todo.")
public class Todo {
    /*
    GenerationType.SEQUENCE
    With this strategy, underlying persistence provider must use a database sequence to get the next unique primary key for the 
    entities.
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    GenerationType.TABLE
    With this strategy, underlying persistence provider must use a database table to generate/keep the next unique primary key for 
    the entities.
    @GeneratedValue(strategy = GenerationType.TABLE)
    
    GenerationType.IDENTITY
    This GenerationType indicates that the persistence provider must assign primary keys for the entity using a database identity 
    column. IDENTITY column is typically used in SQL Server. This special type column is populated internally by the table itself 
    without using a separate sequence. If underlying database doesn't support IDENTITY column or some similar variant then the 
    persistence provider can choose an alternative appropriate strategy. In this examples we are using H2 database which doesn't 
    support IDENTITY column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    GenerationType.AUTO
    This GenerationType indicates that the persistence provider should automatically pick an appropriate strategy for the 
    particular database. This is the default GenerationType, i.e. if we just use @GeneratedValue annotation then this value of 
    GenerationType will be used.
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    When @GeneratedValue not used
    If we don't use @GeneratedValue annotation at all, then we have to populate the unique primary keys ourselves.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Todo ID")
    private Long id;
    @ApiModelProperty(notes = "The user associated with the todo")
    private String username;
    @ApiModelProperty(notes = "The description of what is to be done")
    private String description;
    @ApiModelProperty(notes = "The date this activity is to be done")
    private Date targetDate;
    @ApiModelProperty(notes = "The status to show if the activity has been done or not")
    private boolean isDone;
}
