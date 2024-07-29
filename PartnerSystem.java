import java.util.ArrayList;

/**
 * this class was made to act as and genarate a random personality to act as a partner for the prisoner's Dilemma.
 *
 * @author (Jack ward)
 * @version (13/7/24)
 */
public class PartnerSystem
{
    private String[] personality = {"Hopeful","Copykitten","Copycat","Sherlock","Grudge","Cynic"};
    private final int MIN_P = 0;//the min of number for a partner
    private final int MAX_P = 5;//the max of number for a partner
    int selectedPartner = (int)Math.floor(Math.random() * ((MAX_P - MIN_P) + 1) + MIN_P);
    Boolean PartnerDeny;
    ArrayList<Boolean>playerResponses = new ArrayList<Boolean>();
    public PartnerSystem()
    {
    }
    
    public boolean getResponce(boolean playerChoice)
    {
        playerResponses.add(playerChoice);
        switch (personality[selectedPartner]){
            case"Hopeful":
                PartnerDeny=true;
                break;
            case"Copykitten":
                if (playerResponses.size() < 2) {
                    PartnerDeny=true;
                } else {
                    //If the player denied last time, it will not betray you
                    if (playerResponses.get(playerResponses.size() -1) == true) {
                        PartnerDeny=true;
                        //If the player's responce before that one was denied, copykitten will still deny
                    } else if (playerResponses.get(playerResponses.size() - 2) == true) {
                        PartnerDeny=true;
                    } else {
                        PartnerDeny=false;
                    }
                }
                break;
            case"Copycat":
                //Copycat will deny if the player did last time, or if its the first round.
                if (playerResponses.size() < 1 || playerResponses.get(playerResponses.size() -1) == true) {
                    PartnerDeny=true;
                } else {
                    PartnerDeny=false;
                }
                break;
            case"Sherlock":
                //Sherlock denies then blames. If the player ever blames him, he becomes copycat, otherwise, he always blames
                if (playerResponses.size() < 1) {
                    PartnerDeny=true;
                } else if (playerResponses.size() < 2) {
                    PartnerDeny=false;
                } else if (playerChoice == false) {
                    PartnerDeny=false;
                    selectedPartner = 2; //Copycat
                } else {
                    PartnerDeny=false;
                }
                break;
            case"Grudge":
                boolean betrayed = false;
                for (boolean playerResponse : playerResponses) {
                    if (playerResponse == false) {
                        betrayed = true;
                        break;
                    }
                }
                PartnerDeny = !betrayed;
                break;
            case"Cynic":
                PartnerDeny=false;
                break;
        }
        
        return PartnerDeny;
        
    }

}
