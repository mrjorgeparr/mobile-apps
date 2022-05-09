package com.example.funniflier2.db;

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

    public User(String email, String password, String name)
    {

        this.email = email;
        this.password = password;
        this.name = name;
    }

    //Getters
    public long getId(){ return this.id; }
    public String getName(){ return this.name; }
    public String getEmail(){ return this.email; }
    public String getPassword(){ return this.password; }

    //Setters
    public void setId(long id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setEmail(String email){ this.email = email; }
    public void setPassword(String password){ this.password = password; }
}
