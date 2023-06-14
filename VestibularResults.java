import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class VestibularResults {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get("/home/lramon2001/medicina.txt");
        String text = new String(Files.readAllBytes(path));

        // Replace all newlines with a space unless they're followed by a candidate ID
        Pattern pattern = Pattern.compile("\n(?!\\d)");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");

        // Now split the text into records by "/"
        String[] records = text.split("/");

        // Process each record
        List<Candidate> candidates = new ArrayList<>();
        for (String record : records) {
            String[] split = record.split(",");
            if (split.length >= 4) {
                String candidateId = split[0].trim();
                String candidateName = split[1].trim();
                Double candidateScore = Double.parseDouble(split[2].trim());
                String candidateRankUniversal = split[3].trim();

             
                // Check if all fields after universal rank are "-"
                boolean onlyUniversal = true;
                for (int i = 4; i < split.length; i++) {
                    if (!"-".equals(split[i].trim())) {
                        onlyUniversal = false;
                        break;
                    }
                }

                if (!"-".equals(candidateRankUniversal) && onlyUniversal) {
                    if(candidateScore>800.00)
                    candidates.add(new Candidate(candidateId, candidateName, candidateScore, candidateRankUniversal));
                }
            }
        }

        // Sort and print the candidates
        candidates.sort(Comparator.comparing(Candidate::getScore).reversed());
        
        
        PrintWriter writer = new PrintWriter("classificacao_universal_vest_engenharia_de_software_unb.csv", "UTF-8");
        writer.println("ID,Name,Score,Rank");

        for (Candidate c : candidates) {
            System.out.println(c);
            writer.println(c);
        }
        
    }
}

class Candidate {
    private String id;
    private String name;
    private double score;
    private String rankUniversal;

    public Candidate(String id, String name, double score, String rankUniversal) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.rankUniversal = rankUniversal;
    }

    public double getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return "Candidate [ID = " + id + ", Name = " + name + ", Score = " + score + ", Rank (Universal) = " + rankUniversal + "]";
    }
}
