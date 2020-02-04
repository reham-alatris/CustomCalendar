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

//setting the number of inflated month begining of the current month


custom.getPropertySetters().setInflatedMonths(3);

custom.montsViewPagerAdapter.notifyDataSetChanged();


//setting Arabic support

custom.getPropertySetters().setArabicSupport(true);

custom.setRotationY(180);

//for engilsh

custom.getPropertySetters().setArabicSupport(false);

custom.setRotationY(0);


//setting font by specifing font path in Assets folder

custom.getPropertySetters().setDay_font_path("fonts/arial.ttf");

//setting day text size in float


custom.getPropertySetters().setDay_text_size(20);

//setting month name text size

custom.getPropertySetters().setCalendar_header_title_size(20);

//setting available days color 

custom.getPropertySetters().setDay_available_text_color("#EB943E");



//setting disable day text color

custom.getPropertySetters().setDay_disable_text_color("#9B9D9F");

//setting calendar background color

custom.getPropertySetters().setCalendar_background_color("#9B9D9F");

//setting calendar header color

custom.getPropertySetters().setCalendar_header_background_color("#9B9D9F");

//set calendar header title color

custom.getPropertySetters().setCalendar_header_title_color("#9B9D9F");

//set calendar header height

custom.getPropertySetters().setCalendar_header_height(40);


//setting disabe days for December for example


//declare integer array with the disable days in december

int []janDisableDays=new int[]{3,4,5,6};

int []febDisableDays=new int[]{3,4,5,6};

int []marDisableDays=new int[]{3,4,5,6};

int []aprDisableDays=new int[]{3,4,5,6};

int []mayDisableDays=new int[]{3,4,5,6};

int []junDisableDays=new int[]{3,4,5,6};

int []julDisableDays=new int[]{3,4,5,6};

int []augDisableDays=new int[]{3,4,5,6};

int []sepDisableDays=new int[]{3,4,5,6};

int []octDisableDays=new int[]{3,4,5,6};

int []novDisableDays=new int[]{3,4,5,6};

int []DecDisableDays=new int[]{3,4,5,6};


custom.getPropertySetters().setDECdays(DecDisableDays);

//for setting disable days in January

custom.getPropertySetters().setJANdays(janDisableDays);

//for setting disable days in feb

custom.getPropertySetters().setFEBdays(febDisableDays);

//for setting disable days in march

custom.getPropertySetters().setMARday(marDisableDays);

//for setting disable days in april

custom.getPropertySetters().setAPRdays(aprDisableDays);

//for setting disable days in may

custom.getPropertySetters().setMAYdays(mayDisableDays);

//for setting disable days in june

custom.getPropertySetters().setJUNdays(junDisableDays);

//for setting disable days in july

custom.getPropertySetters().setJULdays(julDisableDays);

//for setting disable days in augsut

custom.getPropertySetters().setAUGdays(augDisableDays);

//for setting disable days in septmber

custom.getPropertySetters().setSEPdays(sepDisableDays);

//for setting disable days in octoebr

custom.getPropertySetters().setOCTdays(octDisableDays);

//for setting disable days in november

custom.getPropertySetters().setNOVdays(novDisableDays);


//setting inflated months number starting the current month

custom.getPropertySetters().setInflatedMonths(3);

custom.montsViewPagerAdapter.notifyDataSetChanged();

//getting user selected date
String date=  custom.getPropertySetters().getSelectedDate();

```


