import java.util.*;
public class Puzzlegame {
    public static void main(String[] args) {

        String que[] = {" Question : Take off my skin, I won't cry but you will.What am I?\n Letter count : 5 \n Choose from : K H E I S O L N R"," Question : What fruit is never found singly? \n Letter count : 4\n Choose from: I E A H S P R T", " Question : If I drink, I die. If I eat, I'm fine.What am I? \n Letter count : 4\n Choose from: S L F E I R W"," Question : What do dogs and trees have in common? \n Letter count : 4\n Choose from: I B A H W S K R J"," Question : What is orange and sounds like a parrot? \n Letter count : 6\n Choose from: E C A D U R N(2) O T"};
        String ans[] = {"ONION", "PEAR", "FIRE", "BARK", "CARROT"};

        puzzle(que, ans);
    }

    public static void puzzle(String que[], String ans[]) {

        String que1[] = {" Question : What liquid can contain the soul?\n Letter count : 3 \n Choose from : F D A E T H N I K", " Question : What's higher than the king? \n Letter count : 5\n Choose from: L I K C W R N O S","Question : What month soldiers hate? \n Letter count : 5\n Choose from: H C K A W R N O M","Question : What can go through glass without breaking it? \n Letter count : 5\n Choose from: I G E H T N K L S"};
        String ans1[] = {"INK", "CROWN","MARCH","LIGHT"};

        int gc = 0;
        boolean loop = true;

        for (int i = 0; i < que.length; i++) {
            System.out.println();
            System.out.println(que[i]);

            Scanner sc = new Scanner(System.in);
            int j = 3;
            while (j > 0) {
                String answer = sc.nextLine();
                if (answer.toUpperCase().equals(ans[i])) {
                    gc += 5;
                    System.out.println("hurrayy ! You won 5 gold coins...\n Your total coins : " + gc);
                    break;
                } else {
                    j--;
                    if (j == 0) {

                        System.out.println("You lost the game!");
                        System.out.println("Your total score :" + gc);
                        System.out.println("RESTART (T/F) ?");
                        String restart = sc.nextLine();
                        if (restart.toUpperCase().equals("T")) {
                            puzzle(que1, ans1);
                        } else {
                            loop = false;
                            break;
                        }



                    } else if (j == 2) {
                        System.out.println("You got two more chances:");
                        continue;
                    } else {

                        System.out.println("You got a last chance:");
                        System.out.println("Want a hint?, Pay a goldcoin for it (Enter yes or no)");


                        Random r = new Random();
                        int b = r.nextInt(ans[i].length() - 1);
                        boolean flag = false;
                        while (true) {
                            String hint = sc.nextLine();


                            if (hint.toLowerCase().equals("yes")) {
                                if (gc == 0) {
                                    System.out.println("Ohhh no :( You dont have enough goldcoins to pay! \n Try your last chance:");
                                    break;

                                } else {
                                    switch (b) {
                                        case 0:
                                            System.out.println("The " + (int) (b + 1) + "st character is : " + ans[i].charAt(b));
                                            break;
                                        case 1:
                                            System.out.println("The " + (int) (b + 1) + "nd character is : " + ans[i].charAt(b));
                                            break;
                                        case 2:
                                            System.out.println("The " + (int) (b + 1) + "rd character is : " + ans[i].charAt(b));
                                            break;
                                        default:
                                            System.out.println("The " + (int) (b + 1) + "th character is : " + ans[i].charAt(b));
                                    }
                                    gc--;
                                    break;
                                }
                            } else if (hint.toLowerCase().equals("no")) {
                                flag = true;
                                break;
                            } else {
                                System.out.println("Enter Yes or No:");
                                continue;
                            }

                        }

                        if (flag == true) {
                            continue;
                        }
                    }
                }
            }
            if (loop == false) {
                System.out.println("Better luck next time!");
                break;
            }
            if (i == que.length-1) {
                System.out.println("You win!");
//                puzzle(que1,ans1);

            }
        }
    }
}
