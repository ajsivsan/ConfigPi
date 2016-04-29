package com.ajsivsan.configpi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@RestController
public class LightController {
	private static GpioPinDigitalOutput pin;
	@RequestMapping("/")
	public String home(){
		return "Welcomd to ConfigPi";
	}
	public String light(){
		if(pin == null){
			GpioController gpio = GpioFactory.getInstance();
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Light", PinState.LOW);
		}
		pin.toggle();
		return "Success changing light state";
	}
}
