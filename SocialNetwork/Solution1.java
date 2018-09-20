import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class SocialNetwork {
	ArrayList <User> user1 = new ArrayList<User>();
	ArrayList <User> user2 = new ArrayList<User>();
	
	void addNewUser(User user) {
        int flag = 0;
        if (user1.size() == 0) {
            user1.add(user);
        }
        else {
            for (User i: user1) {
                if (i.getName().equals(user.getName())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                user1.add(user);
            }  
        }
    }

    // Boolean checkUser(User user) {
    //     for(User i: user1) {
    //         if (i.getName().equals(user.getName())) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

	void addConnection(User user) {
        for (User i: user1) {
            if (i.getName().equals(user.getName())) {
                user2.add(user);
            }
        }
        // for (User j: user2) {
        //     System.out.println(j.getfriends());
        // }
    }

	void getConnections(String user) {
        int flag = 0;
        for (User i: user1) {
            if (i.getName().equals(user.getName())) {
               flag = 1; 
               break;
            }
        }
        if (flag == 0) {
            System.out.println("Not a user in Network");
        }
        for (User i: user2) {
            if (i.getName().equals(user)) {
                System.out.println(i.getfriends());
            }
        }
    }

    void network() {
        for (User i: user1) {
            System.out.print(i.getName() + ": [");
            for (User j: user2) {
                if (i.getName().equals(j.getName())) {
                    System.out.print(j.getfriends() + " ");
                }
            }
            System.out.print("], ");
        } 
    }
    void CommonConnections() {
        
    }
}


class User {
	String name;
	String friends;
	User(final String name1) {
	    this.name = name1;
	}
    User(final String name1, final String friend) {
    	this.name = name1;
        this.friends = friend;
    }
	String getName() {
        return this.name;
	}
	void setName(final String name2) {
		this.name = name2;
    }
    String getfriends() {
        return this.friends;
    }
    void setfriends(final String friend1) {
        this.friends = friend1;
    }
}

public final class Solution1 {

	private Solution1() {

	}
	public static void main(final String[] args) {
        SocialNetwork sn = new SocialNetwork();
        ArrayList<String> friends = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] token = scan.nextLine().replace("is connected to", "isconnectedto").replace(", ", ",").replace(".", "").split(" ");
            if (token.length > 1) {
                if (token[1].equals("isconnectedto")) {
                String temp = token[0];
                token[0] = token[1];
                token[1] = temp;
                }
            }

            switch(token[0]) {
                case "isconnectedto":
                String[] check = token[2].split(",");
                User user = new User(token[1]);
                sn.addNewUser(user);
                for (int i = 0; i < check.length; i++) {
                    User u = new User(token[1], check[i]);
                    sn.addConnection(u);
                }
                break;
                case "addConnections":
                User user1 = new User(token[1], token[2]);
                sn.addConnection(user1);
                break;
                case "getConnections":
                sn.getConnections(token[1]);
                break;
                case "Network":
                sn.network();
                break;
                case "CommonConnections":
                //sn.CommonConnections(token[1], token[2]);
                break;
                default:
                break;
            }
        }
    }

}