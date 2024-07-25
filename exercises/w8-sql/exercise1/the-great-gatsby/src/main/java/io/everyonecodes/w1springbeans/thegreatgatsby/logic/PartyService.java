package io.everyonecodes.w1springbeans.thegreatgatsby.logic;

import io.everyonecodes.w1springbeans.thegreatgatsby.model.Invitation;
import io.everyonecodes.w1springbeans.thegreatgatsby.model.InvitationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class PartyService {
    private final InvitationRepository invitationRepository;

    public PartyService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    // I need to check the logic for the four operations:

    public void invitationManager(){
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        do {
            printMenu();
            String option = scanner.nextLine();
            continueLoop = selectAction(option);

        } while (continueLoop);

    }

    // 0.0. - Menu selector
    private boolean selectAction(String option){
        if(!option.equals("4")){
            switch (option) {
                case "1" -> invitePerson();
                case "2" -> showAllInvitations();
                case "3" -> concludeParty();
            }
           return true;

        } else return false;
    }

    // 0.- Welcome Menu
    private void printMenu(){
        System.out.println("The Great Gatsby Party Invitation Manager\n" +
                "MENU\n" +
                "\n" +
                "1.- Invite a person.\n" +
                "2.- Show all invitations.\n" +
                "3.- Conclude the current party.\n" +
                "4.- Exit.\n" +
                "\n" +
                "> Choose one option (1-4): \n");
    }

    // 1.- Invite a person.

    private void invitePerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("INVITE A PERSON");
        System.out.println("Write the person’s name:");
        String name = scanner.nextLine();

        invitationRepository.save(new Invitation(name));

        System.out.println(name + " was added to the list");
    }
    //2.- Show all invitations.
    private void showAllInvitations(){
        List<Invitation> invitations = invitationRepository.findAll();
        System.out.println("SHOW ALL INVITATIONS");
        if(invitations.isEmpty()){
            System.out.println("No invitations yet");
        } else for(Invitation invitation : invitations){
            System.out.println(invitation.getName());
        }
    }

    //3.- Conclude the current party.
    private void concludeParty(){
        System.out.println("CONCLUDE THE CURRENT PARTY");
        System.out.println("Do you want to conclude the current party? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if(option.equals("y")){
            invitationRepository.deleteAll();
            System.out.println("The current party is concluded");
        } else System.out.println("The current party is still going");
    }
    //4.- Exit.


}
