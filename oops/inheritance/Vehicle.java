package com.oops.inheritance;

interface Car
{
	int speed=80;
	public void totalDistance();
}
interface Bus
{
	int distance=50;
	public void speed();
}
public class Vehicle implements Car,Bus
{
	int totalDistance;
	int avgSpeed;
	public void totalDistance()
	{
	totalDistance=speed*distance;
	System.out.println("Total Distance Travelled : "+totalDistance);
	}
	public void speed()
	{
	int avgSpeed=totalDistance/speed;
	System.out.println("Average Speed maintained : "+avgSpeed);
}
public static void main(String args[])
{
	Vehicle v=new Vehicle();
	v.totalDistance();
	v.speed();
}
}