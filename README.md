# EandPEditText
A  Custom designed EditText with email validation for inputting Emails and Password EditText for inputting Password along with show and hide option as given in the below demo. You can changethe icons and the background color if you want. For more details please check the sample app<br></br>  
![Screenshot](http://i.giphy.com/d1E0XcwL6bq0zyp2.gif) 
#HOW TO SETUP?
To use this Library in your project you first need to: 

1) Add this to your root ```build.gradle``` file:  
```groovy
allprojects{  
    repositories {  
        ......  
        maven {
        
        url 'https://jitpack.io'//TODO  
        
        }   
    }    
}  
<br></br>
```  
2) And then in your Project's ```build.gradle``` file:  
```groovy  
dependencies {  
    .......  
    
    compile 'com.github.aamirwahid5:EandPEditText:1.0' //TODO  
       
}  
```  
#HOW TO USE:  
Firstly include as you do with Simple Simple EditText :
1) For Email EditText:
```xml
<project.aamir.sheikh.eandpedittext.EEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    </project.aamir.sheikh.eandpedittext.EEditText>
```  
2) For Password EditText:
```xml
<project.aamir.sheikh.eandpedittext.PEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    </project.aamir.sheikh.eandpedittext.PEditText>
```
and then in your java Code:
```java
    EEditText eEditText=(EEditText) findViewById(R.id.eedit);  //Change with your Id
    PEditText pEditText=(PEditText) findViewById(R.id.pedit);  //Change with your Id
```
