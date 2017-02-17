package ma.wafa.cream.service.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ma.wafa.cream.web.rest.dto.ProspectImportDTO;

public class CsvFileReader {
    
    private static final int NOM = 0;
    private static final int PRENOM = 1;
    private static final int TEL = 2;
    private static final int CIN = 3;
    private static final int RC = 5;
    private static final int IMMATRICULATION = 5;
    private static final int PUISSANCE = 6;
    private static final int CARBURANT = 7;
    private static final int ANNEE_VIGNTTE = 8;
    private static final int DATE_CIRCULATION = 9;
    private static final int CODE_AGENCE = 10;
    private static final String SEPARATOR = ";";
    
    private static final String path = "C:/_dev/importCRM.csv";
    
    public static List<ProspectImportDTO> run(String pathFile) throws IOException {
        
        List<ProspectImportDTO> prospectImportDTOList = new ArrayList<ProspectImportDTO>();
        String csvFile = pathFile;
        String line = "";
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            // ignor first line
            bufferedReader.readLine();
            
            while ((line = bufferedReader.readLine()) != null) {
                
                // use comma as separator
                String[] ligne = line.split(SEPARATOR);
                
                ProspectImportDTO prospect = new ProspectImportDTO();
                prospect.setNom(ligne[NOM]);
                prospect.setPrenom(ligne[PRENOM]);
                prospect.setTel(ligne[TEL]);
                prospect.setCin(ligne[CIN]);
                prospect.setRc(ligne[RC]);
                prospect.setImmatriculation(ligne[IMMATRICULATION]);
                prospect.setPuissance(ligne[PUISSANCE]);
                prospect.setCarburant(ligne[CARBURANT]);
                prospect.setAnnee_vignette(ligne[ANNEE_VIGNTTE]);
                prospect.setDate_circulation(ligne[DATE_CIRCULATION]);
                prospect.setCode_agence(ligne[CODE_AGENCE]);
                
                prospectImportDTOList.add(prospect);
            }
        }
        
        return prospectImportDTOList;
        
    }
}
