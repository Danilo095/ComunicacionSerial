//Programa que envía datos de sensores de manera serial a java
#include <DHT.h>

const int sensorDHT=A0;
int temp,humedad;
DHT dht (sensorDHT,DHT11);

const int echo = 2;
const int trigger = 3;
const int co2D=4;
const int co2A=A1;
int valor;
int limite;
long duracion,distancia;
int i=0;

void setup() {
  Serial.begin(9600);
  dht.begin(); //Iniciamos nuestro sensor DHT11
  pinMode(trigger,OUTPUT);
  pinMode(echo,INPUT);
  pinMode(temp,INPUT);
  pinMode(co2D,INPUT);
  pinMode(co2A,INPUT);
}

void loop() {
  delay(1000);
  //if(Serial.available()>0){
    char selector=Serial.read();
 // Serial.println(selector);
  //delay(1000);
  for(int i=0;i<10;i++){
    if(selector=='A'){
   Temperatura();
  }
  if(selector=='B'){
    Humedad();
  }
  if(selector=='C'){
    Proximidad();
  }
  if(selector=='D'){
    CO2();
  }
 // }
  
 // }
while(i<=0){
     Serial.print(0);
  i=i+1;
}

  }
  
  
  
  

      //while (temp>=24){ //Condición para mantener el ambiente fresco.
       // Serial.println("Ventiladores Encendidos");
        //digitalWrite(ventilador,HIGH); //Encendemos el ventilador
        //temp= dht.readTemperature(); //Volvemos a leer la temperatura
        //delay(2000);
        //}

        //digitalWrite(ventilador,LOW);
 
}
void Temperatura(){
  temp= dht.readTemperature(); //Permite leer la temperatura.
  Serial.print(temp);
  Serial.print("ºC"); //Tempertura: 29ºC
  delay(3000);
  
}

void Humedad(){
  humedad= dht.readHumidity(); //Funcion incluida en la libreria. Permite leer la humedad.
  Serial.print(humedad);
  Serial.println("%"); 
  delay(3000);
}

void Proximidad(){
  digitalWrite(trigger, LOW);
  delayMicroseconds(2);
  digitalWrite(trigger, HIGH);   // genera el pulso de triger por 10ms
  delayMicroseconds(10);
  digitalWrite(trigger, LOW);

  duracion = pulseIn(echo, HIGH);
  distancia = (duracion/2) / 29; 

  Serial.print(distancia);           // envia el valor de la distancia por el puerto serial
  Serial.println("cm"); 
  delay(3000);
}
void CO2(){
  valor=digitalRead(co2D);
  limite=analogRead(co2A);
  Serial.print(limite);
  delay(3000);
}

