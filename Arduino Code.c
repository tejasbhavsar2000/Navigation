#include<SoftwareSerial.h>
const int pingPin = 7; // Trigger Pin of Ultrasonic Sensor
const int echoPin = 6; // Echo Pin of Ultrasonic Sensor
char data = 0; //Variable for storing received data
const int ledPin = 13;
SoftwareSerial BTSerial(2,3); //rx,tx

void setup()
{
// String setName = String("AT+NAME=MyBTBee\r\n"); //Setting name as 'MyBTBee'
Serial.begin(9600); // Starting Serial Terminal
BTSerial.begin(9500);
//BTSerial.print("AT\r\n"); //Check Status
delay(500);
while (BTSerial.available())
{
Serial.write(BTSerial.read());
}
//BTSerial.println(setName); //Send Command to change the name
delay(500);
while (BTSerial.available())
{
Serial.write(BTSerial.read());
}
}

void loop()
{
long inches;
long duration, cm;
pinMode(pingPin, OUTPUT);
digitalWrite(pingPin, LOW);

pinMode(ledPin, OUTPUT);
digitalWrite(ledPin, LOW);
delayMicroseconds(2);
digitalWrite(pingPin, HIGH);
delayMicroseconds(10);
digitalWrite(pingPin, LOW);

pinMode(echoPin, INPUT);
duration = pulseIn(echoPin, HIGH);
inches = microsecondsToInches(duration);
cm = microsecondsToCentimeters(duration);
//Serial.print(inches);
//Serial.print("in, ");
//Serial.print(cm);
//Serial.print("cm");
//Serial.println();
if(inches > 4 && inches <11)
{
BTSerial.print(inches);
}
else if(inches > 12 && inches <24)
{
BTSerial.print(inches);
}
else if(inches > 25 && inches <36)
{
BTSerial.print(inches);
}
else if(inches > 37 && inches <48)
{
BTSerial.print(inches);
}
delay(2000);
}

long microsecondsToInches(long microseconds)
{
return microseconds / 74 / 2;
}

long microsecondsToCentimeters(long microseconds)
{
return microseconds / 29 / 2;
}
