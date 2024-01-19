package com.AMBM.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMBM.model.Especie;
import com.AMBM.model.Mascota;
import com.AMBM.model.Provincia;
import java.io.File;
import java.io.FileReader;

@Service
public class CsvExportService {

	@Autowired
	private EspecieService especieService;

	@Autowired
	private ProvinciaService provinciaService;

	@Autowired
	private MascotaService mascotaService;

	public void exportDataToCsv() {
		exportEspeciesToCsv();
		exportProvinciasToCsv();
		exportMascotasToCsv();
	}

	private void exportEspeciesToCsv() {
		List<Especie> especies = especieService.getAllEspecies();

		String csvFilePath = "D:/WorkspaceSpring/SprWildLife/especies.csv";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(csvFilePath)))) {
			writer.write("Id,Especie");
			writer.newLine();

			for (Especie especie : especies) {
				writer.write(especie.getId() + "," + especie.getEspecie());
				writer.newLine();
			}

			System.out.println("Especies exportadas correctamente a: " + csvFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportProvinciasToCsv() {
		List<Provincia> provincias = provinciaService.getAllProvincias();

		String csvFilePath = "D:/WorkspaceSpring/SprWildLife/provincias.csv";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(csvFilePath)))) {
			writer.write("Id,Provincia");
			writer.newLine();

			for (Provincia provincia : provincias) {
				writer.write(String.format("%d,%s", provincia.getId(), provincia.getProvincia()));
				writer.newLine();
			}

			System.out.println("Provincias exportadas correctamente a: " + csvFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportMascotasToCsv() {
		List<Mascota> mascotas = mascotaService.getAllMascotas();

		String csvFilePath = "D:/WorkspaceSpring/SprWildLife/mascotas.csv";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(csvFilePath)))) {
			writer.write("Id,Descripcion,Edad,Foto,Nombre,Especie_id,Provincia_id");
			writer.newLine();

			for (Mascota mascota : mascotas) {
				writer.write(String.format("%d,%s,%d,%s,%s,%d,%d", mascota.getId(), mascota.getDescripcion(),
						mascota.getEdad(), mascota.getFoto(), mascota.getNombre(), mascota.getEspecie().getId(),
						mascota.getProvincia().getId()));
				writer.newLine();
			}

			System.out.println("Mascotas exportadas correctamente a: " + csvFilePath);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void importMascotasFromCsv() {
		String csvFilePath = "D:/WorkspaceSpring/SprWildLife/mascotas.csv";

		try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
			String line;

			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");

				Mascota mascota = new Mascota();
				mascota.setId(Integer.parseInt(data[0].trim()));
				mascota.setDescripcion(data[1].trim());
				mascota.setEdad(Integer.parseInt(data[2].trim()));
				mascota.setFoto(data[3].trim());
				mascota.setNombre(data[4].trim());

				Especie especie = especieService.getEspecieById(Long.parseLong(data[5].trim()));
				Provincia provincia = provinciaService.getProvinciaById(Long.parseLong(data[6].trim()));

				mascota.setEspecie(especie);
				mascota.setProvincia(provincia);

				mascotaService.saveMascota(mascota);
			}

			System.out.println("Restauración de mascotas desde CSV completada.");
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
