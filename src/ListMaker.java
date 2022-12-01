import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker
{
    static ArrayList<String> list = new ArrayList<>();


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";
        int num = 0;

        do
        {
            //display list
            displayList();
            //display menu
            //get a menu choice
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            //execute the choice
            switch (cmd)
            {
                case "A":
                    //prompt user for list item
                    //make sure it is not an empty string
                    String item = SafeInput.getNonZerolength(in, "Enter the item you would like to add");
                    //add to list
                    list.add(item);
                    break;
                case "D":
                    //prompt user for the number of item to delete
                    num = SafeInput.getRangedInt(in, "Enter the item number you would like to remove", 1, list.size());
                    //translate the number to an index by subtracting 1
                    //remove item from list
                    list.remove(num-1);
                    break;
                case "P":
                    break;
                case "Q":

                    System.exit(0);
                    break;
            }


        }while (!done);



    }

    private static void displayList()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        if(list.size() != 0) {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i + 1, list.get(i));
            }
        }
        else
            System.out.println("+++            List is empty            +++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }


}