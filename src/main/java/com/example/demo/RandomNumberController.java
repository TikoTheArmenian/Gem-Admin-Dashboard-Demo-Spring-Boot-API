package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



// use @CrossOrigin(origins = "*") to allow requests from any client
@RestController
@CrossOrigin(origins = "http://localhost:3000") // allow requests from this client
public class RandomNumberController {

	private final List<Integer> numbers = new ArrayList<>();


	@GetMapping("/random")
	public String getRandomNumber() {
		Random random = new Random();
		String s = "";
		try {
			File myObj = new File("src/main/resources/RandomNumbers.txt");
			if (!myObj.exists()) {
				myObj.createNewFile();
			}

			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				s += myReader.nextLine();
			}
			myReader.close();

			FileWriter myWriter = new FileWriter("src/main/resources/RandomNumbers.txt");
			int n = random.nextInt();
			myWriter.write(s+n + ", ");
			myWriter.close();
			s += n;

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}


		return s;
	}
}
