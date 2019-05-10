#include <LiquidCrystal_I2C.h>
#include <Wire.h> //configurar puertos base
#include <CayenneMQTTESP8266.h>

const int foco=14;
const int ventilador=12;
const int niquelina=13;

char red[] = "HUAWEI P smart";
char passwordWifi[] = "f7b8088fd709";

//variables que nos permien conectar con la pagina de Cayenne
char usuario[] = "845cf9e0-66cf-11e9-888e-af3db3cb8c63";
char password[] = "66c1209cee2a1c3c14032315965d60b1cfd3af30";
char clienteID[] = "9a9b4ac0-6794-11e9-bdb5-dfd20f02ea3f";

LiquidCrystal_I2C lcd(0x27, 16, 2); //protocolo 0x27, 16x2

void setup() {
pinMode(foco, OUTPUT);
pinMode(ventilador, OUTPUT);
pinMode(niquelina, OUTPUT);
pinMode(2, OUTPUT);
Wire.begin(D2, D1); // D1 = SCL | D2 = SDA
lcd.begin(); // Iniciamos el LCD
lcd.backlight(); // Prendemos la Iluminacion del LCD
lcd.clear();
Cayenne.begin(usuario, password, clienteID, red, passwordWifi);

Serial.begin(115200);
}

void loop() {
Cayenne.loop();
if(Serial.available()>0){
  int input=Serial.read();
//foco
  if(input=='0'){
    digitalWrite(foco, HIGH);  
  }
  else if(input=='1'){
    digitalWrite(foco, LOW);
  }
//ventilador
    if(input=='2'){
    digitalWrite(ventilador, HIGH);  
  }
  else if(input=='3'){
    digitalWrite(ventilador, LOW);
  }
//niquelina
    if(input=='4'){
    digitalWrite(niquelina, HIGH);  
  }
  else if(input=='5'){
    digitalWrite(niquelina, LOW);
  }
//lcd
    if(input=='6'){
      
      lcd.clear();
      digitalWrite(2, LOW);
      delay(1000);
      digitalWrite(2, HIGH);
      delay(1000);
      lcd.setCursor(0, 0); // Cursor0 , Linea0
      lcd.print("Tecno. Software");
      lcd.setCursor(0, 1); // Cursor0 , Linea1
      lcd.print("Bienvenidos");
      delay(1000);
     
  }
  else if(input=='7'){
      lcd.clear();
  }
}
}

CAYENNE_IN(1)
{ 
   int canalLed = getValue.asInt();
   digitalWrite(foco, canalLed );
}

CAYENNE_IN(2)
{ 
   int canalVentilador = getValue.asInt();
   digitalWrite(ventilador, canalVentilador);
}
CAYENNE_IN(3)
{ 
   int canalNiquelina = getValue.asInt();
   digitalWrite(niquelina, canalNiquelina);
}
