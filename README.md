 # CustomCalendar
 
Android Library that is  is a fully customized and Alows you to
Support Arabic and English,  Disable days in any month and previous days in the current month and certain day in Week and inflate certain months from the current month according to the preference

## Installing

Add the JitPack repository to your build file 

in the root build.gradle 

```
 allprojects { repositories { ... maven { url 'https://jitpack.io' } } }
 
```

 Add the dependency

	dependencies {
	        implementation 'com.github.NatSaudi:NatSaudiCalendar:v1'
	}

## How to use

first : declare the view in the layout XML
```xml
  <com.example.comnatsaudilibraryandroidcalander.CustomCalendarView
        android:layout_width="match_parent"
        android:id="@+id/custom"
        android:layout_height="wrap_content">
    </com.example.comnatsaudilibraryandroidcalander.CustomCalendarView>
```

second : refer to it's ID in Activity JAVA
```java

custom = (CustomCalendarView) findViewById(R.id.custom);

```
All Additionial Attrributes are explained in the Project [Wiki](https://github.com/reham-alatris/CustomCalendar/wiki/)

## Author

[Reham Alatris](https://github.com/reham-alatris)

## License
```
MIT License

Copyright (c) 2020 reham alatris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```






