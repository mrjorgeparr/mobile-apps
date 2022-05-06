package com.example.funniflier2.db2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//@Entity(indices = [Index(value = ["name"], unique = true)]
@Entity(indices = {@Index(value = {"email"},unique = true)})

public class User
{
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="password")
    private String password;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="surname1")
    private String surname1;

    @ColumnInfo(name="surname2")
    private String surname2;

    public User(String email, String password, String name)
    {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
    }

    //Getters
    public long getId(){ return this.id; }
    public String getName(){ return this.name; }
    public String getEmail(){ return this.email; }
    public String getPassword(){ return this.password; }
    public String getSurname1(){ return this.surname1; }
    public String getSurname2(){ return this.surname2; }

    //Setters
    public void setId(long id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setEmail(String Email){ this.email = email; }
    public void setPassword(String password){ this.password = password; }
    public void setSurname1(String surname1){ this.email = surname1; }
    public void setSurname2(String surname2){ this.password = surname2; }
}
