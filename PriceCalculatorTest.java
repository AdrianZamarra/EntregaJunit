package com.gmq.entornos.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class PriceCalculatorTest {
	
	PriceCalculator calculator;
	
	@BeforeEach
	 void setup() {
		calculator = new PriceCalculator();
	}
	//TEST 1
	
	@Test
	
	void should_calculate_price() {
		
		Integer[] sumaProduct = new Integer[5];
		
		Integer resultado = 0;
				
		
			for (int i = 0; i < sumaProduct.length; i++) {
				sumaProduct[i] = i + 2;
				resultado += sumaProduct[i];
			}
			assertEquals(20, calculator.sumProductsPrice(sumaProduct));
		
		
	}
	 
	
	
	//TEST 2
	@ParameterizedTest
	@MethodSource("PriceCalculator")
	void should_sum_price(String nombre,int numofProduct,int result){
		assertEquals(result, calculator.calculatePrice(nombre, numofProduct));
	}
	static Stream<Arguments> PriceCalculator(){
		
		return Stream.of(
				
				Arguments.of("CAR",1,19650),
				Arguments.of("HOUSE",1,226000),
				Arguments.of("APPARTMENT",1,226000),
				Arguments.of("TRUCK",1,78600),
				Arguments.of("FOOD",1,52),
				Arguments.of("PLANE",1,4935000),
				Arguments.of("HELICOPTER",1,1974000)
							
				);
		
	}

}
