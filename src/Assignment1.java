import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Assignment1 {
    public static class Vaccine{
        String vname;
        int vdoses;
        int vgap;
        Vaccine(String name, int doses, int gap){
            vname = name;
            vdoses = doses;
            vgap = gap;
        }
        void display(){
            System.out.print("Vaccine Name: " + vname + ", ");
            System.out.print("Number of Doses: " + vdoses + ", ");
            System.out.print("Gap between Doses: " + vgap);
        }
    }
    public static class Hospital{
        String hname;
        int hpin;
        int hunique_id;
        Hospital(String name, int pin, int unique_id){
            hname = name;
            hpin = pin;
            hunique_id = unique_id;
        }
        void display(){
            System.out.print("Hospital Name: " + hname + ", ");
            System.out.print("PinCode: " + hpin + ", ");
            System.out.print("Unique ID: " + hunique_id);
        }
    }
    public static class Slot{
        int shid;
        int sday;
        int squantity;
        String vname;
        String hname;
        int sgap;
        Slot(int hid, int day, int quantity, String name, String hospital, int gap){
            shid = hid;
            sday = day;
            squantity = quantity;
            vname = name;
            hname = hospital;
            sgap = gap;
        }
        void display(){
            System.out.println("Slot added by Hospital " + shid + " for Day: " + sday + ", " + "Available Quantity: " + squantity + " of Vaccine " + vname);
        }
    }
    public static class Citizen{
        String cname;
        int cage;
        String cunique_id;
        String cstatus;
        String cvname;
        int cdoses = 0;
        int cslot = 0;
        Citizen(String name, int age, String unique_id, String status){
            cname = name;
            cage = age;
            cunique_id = unique_id;
            cstatus = status;
        }
        void display(){
            System.out.print("Citizen Name: " + cname + ",");
            System.out.print(" Age: " + cage + ",");
            System.out.print(" Unique ID: " + cunique_id);
        }
        void status(){
            System.out.println(cstatus);
        }
        void vaccine_name(String vname){
            cvname = vname;
        }
        void add_doses_given(){
            cdoses++;
        }
        void add_slot_day(int slot){
            cslot = slot;
        }
    }
    public static void main(String[] args) {
        int tag = 0;
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        Vaccine[] vaccines;
        vaccines = new Vaccine[100];
        Hospital[] hospitals;
        hospitals = new Hospital[100];
        Citizen[] citizens;
        citizens = new Citizen[100];
        Slot[] slots;
        slots = new Slot[100];
        int vcount = 0;
        int hcount = 0;
        int ccount = 0;
        int scount = 0;
        System.out.println("\nCoWin Portal initialized....");
        label:
        while (tag != 1) {
            System.out.println("\n---------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter Query: ");
            int input = sc.nextInt();
            if (input == 8) {
                tag += 1;
            } else if (input == 1) {
                int val = 0;
                System.out.print("Vaccine Name: ");
                String name = s.next();
                for (int i = 0; i < vcount; i++) {
                    if (Objects.equals(vaccines[i].vname, name)) {
                        System.out.println("This Vaccine already exists!");
                        val++;
                        break;
                    }
                }
                if (val == 0) {
                    System.out.print("Number of Doses: ");
                    int doses = sc.nextInt();
                    System.out.print("Gap between Doses: ");
                    int gap = sc.nextInt();
                    vaccines[vcount] = new Vaccine(name, doses, gap);
                    vaccines[vcount].display();
                    vcount++;
                }
            } else if (input == 2) {
                Random rand = new Random();
                System.out.print("Hospital Name: ");
                String name = s.next();
                int val = 0;
                for (int i = 0; i < hcount; i++) {
                    if (Objects.equals(hospitals[i].hname, name)) {
                        System.out.println("This Hospital already exists!");
                        val++;
                        break;
                    }
                }
                if (val == 0) {
                    System.out.print("PinCode: ");
                    int pin = sc.nextInt();
                    int unique_id = rand.nextInt(999999);
                    hospitals[hcount] = new Hospital(name, pin, unique_id);
                    hospitals[hcount].display();
                    hcount++;
                }
            } else if (input == 3) {
                System.out.print("Citizen Name: ");
                String name = s.next();
                System.out.print("Age: ");
                int age = sc.nextInt();
                System.out.print("Unique ID: ");
                String unique_id = s.next();
                int val = 0;
                for (int i = 0; i < ccount; i++) {
                    if (Objects.equals(citizens[i].cunique_id, unique_id)) {
                        System.out.println("This Citizen already exists!");
                        val++;
                    }
                }
                if (val == 0) {
                    if(age > 18) {
                        citizens[ccount] = new Citizen(name, age, unique_id, "REGISTERED");
                        citizens[ccount].display();
                        ccount++;
                    }
                    else{
                        System.out.println("Citizen Name: " + name + ", " + "Age: " + age + ", " + "Unique ID: " + unique_id);
                        System.out.println("Only above 18 are allowed!");
                    }
                }
            } else if (input == 4) {
                System.out.print("Enter Hospital ID: ");
                int id = sc.nextInt();
                String hname = "";
                int val = 0;
                for (int x = 0; x < hcount; x++) {
                    if (hospitals[x].hunique_id == id) {
                        hname = hospitals[x].hname;
                        val++;
                    }
                }
                if (val > 0) {
                    System.out.print("Enter number of Slots to be added: ");
                    int number = sc.nextInt();
                    for (int i = 0; i < number; i++) {
                        System.out.print("Enter Day Number: ");
                        int day = sc.nextInt();
                        System.out.print("Enter Quantity: ");
                        int quantity = sc.nextInt();
                        System.out.println("Select Vaccine");
                        for (int j = 0; j < vcount; j++) {
                            System.out.println(j + ". " + vaccines[j].vname);
                        }

                        int choice = sc.nextInt();
                        slots[scount] = new Slot(id, day, quantity, vaccines[choice].vname, hname, vaccines[choice].vgap);
                        slots[scount].display();
                        scount++;
                    }
                }
                else{
                    System.out.println("Hospital does not exist!");
                }
            } else if (input == 5) {
                System.out.print("Enter patient Unique ID: ");
                String puid = s.next();
                int val = 0;
                for (int i = 0; i < ccount; i++) {
                    if (Objects.equals(citizens[i].cunique_id, puid)) {
                        val++;
                        if (Objects.equals(citizens[i].cstatus, "FULLY VACCINATED")){
                            System.out.println("Citizen is already fully vaccinated!");
                            continue label;
                        }
                    }
                }
                if (val > 0) {
                    System.out.println("1. Search by Area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter option: ");
                    int option = sc.nextInt();
                    if (option == 1) {
                        System.out.print("Enter PinCode: ");
                        int pin = sc.nextInt();
                        int flag = 0;
                        for (int i = 0; i < hcount; i++) {
                            if (pin == hospitals[i].hpin) {
                                System.out.print(hospitals[i].hunique_id);
                                System.out.print(" ");
                                System.out.print(hospitals[i].hname);
                                flag++;
                            }
                        }
                        if (flag > 0) {
                            System.out.println("\n");
                            System.out.print("Enter Hospital ID: ");
                            int id = sc.nextInt();
                            int l = 0;
                            String[] arr = new String[scount];
                            int[] slot_days = new int[scount];
                            int r = 0;
                            for (int j = 0; j < scount; j++) {
                                if (id == slots[j].shid) {
                                    for (int i = 0; i < ccount; i++){
                                        if(Objects.equals(citizens[i].cunique_id, puid)){
                                            if(citizens[i].cslot != 0){
                                                if ((citizens[i].cslot + slots[j].sgap) <= slots[j].sday && Objects.equals(citizens[i].cvname, slots[j].vname)){
                                                    System.out.println(l + "-> " + "Day: " + slots[j].sday + " Available Qty: " + slots[j].squantity + " Vaccine: " + slots[j].vname);
                                                    arr[l] = slots[j].vname;
                                                    slot_days[l] = slots[j].sday;
                                                    l++;
                                                    r++;
                                                }
                                            }
                                            else{
                                                System.out.println(l + "-> " + "Day: " + slots[j].sday + " Available Qty: " + slots[j].squantity + " Vaccine: " + slots[j].vname);
                                                arr[l] = slots[j].vname;
                                                slot_days[l] = slots[j].sday;
                                                l++;
                                                r++;
                                            }
                                        }
                                    }
                                }
                            }
                            if(r == 0){
                                System.out.println("No Slots Available!");
                            }
                            if (l > 0) {
                                System.out.print("Choose Slot: ");
                                int choose = sc.nextInt();
                                for (int k = 0; k < ccount; k++) {
                                    if (Objects.equals(puid, citizens[k].cunique_id)) {
                                        System.out.println(citizens[k].cname + " vaccinated with " + arr[choose]);
                                        citizens[k].vaccine_name(arr[choose]);
                                        citizens[k].add_doses_given();
                                        citizens[k].add_slot_day(slot_days[choose]);
                                        for (int a = 0; a < scount; a++) {
                                            if (id == slots[a].shid && Objects.equals(arr[choose], slots[a].vname)) {
                                                slots[a].squantity = slots[a].squantity - 1;
                                            }
                                        }
                                        for (int j = 0; j < vcount; j++) {
                                            if (Objects.equals(vaccines[j].vname, citizens[k].cvname)) {
                                                if (citizens[k].cdoses == vaccines[j].vdoses) {
                                                    citizens[k].cstatus = "FULLY VACCINATED";
                                                } else if (citizens[k].cdoses > 0 && citizens[k].cdoses < vaccines[j].vdoses) {
                                                    citizens[k].cstatus = "PARTIALLY VACCINATED";
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("This Hospital ID does not exist!");
                            }
                        } else {
                            System.out.println("This PinCode does not exist!");
                        }
                    } else if (option == 2) {
                        System.out.print("Enter Vaccine Name: ");
                        String vaccine = s.next();
                        int n = 0;
                        int var = 0;
                        for (int i = 0; i < vcount; i++) {
                            if (Objects.equals(vaccines[i].vname, vaccine)) {
                                System.out.println("This Vaccine already exists!");
                                var++;
                            }
                        }
                        if (var == 0){
                            System.out.println("This vaccine does not exist!");
                            continue label;
                        }
                        for (int i = 0; i < scount; i++) {
                            if (Objects.equals(slots[i].vname, vaccine)) {
                                System.out.println(slots[i].shid + " " + slots[i].hname);
                                n++;
                            }
                        }
                        for (int x = 0; x < ccount; x++){
                            if(citizens[x].cdoses > 0 && Objects.equals(citizens[x].cunique_id, puid)){
                                if(!Objects.equals(citizens[x].cvname, vaccine)){
                                    System.out.println("This Citizen has already taken another vaccine!");
                                    continue label;
                                }
                            }
                        }
                        if (n > 0) {
                            System.out.print("Enter Hospital ID: ");
                            int id = sc.nextInt();
                            int l = 0;
                            String[] arr = new String[scount];
                            int[] slot_days = new int[scount];
                            int r = 0;
                            for (int j = 0; j < scount; j++) {
                                if (id == slots[j].shid) {
                                    for (int i = 0; i < ccount; i++){
                                        if (Objects.equals(citizens[i].cunique_id, puid)) {
                                            if (citizens[i].cslot != 0) {
                                                if ((citizens[i].cslot + slots[j].sgap) <= slots[j].sday && Objects.equals(citizens[i].cvname, slots[j].vname)) {
                                                    System.out.println(l + "-> " + "Day: " + slots[j].sday + " Available Qty: " + slots[j].squantity + " Vaccine: " + slots[j].vname);
                                                    arr[l] = slots[j].vname;
                                                    slot_days[l] = slots[j].sday;
                                                    l++;
                                                    r++;
                                                }
                                            } else {
                                                if(Objects.equals(slots[j].vname, vaccine)) {
                                                    System.out.println(l + "-> " + "Day: " + slots[j].sday + " Available Qty: " + slots[j].squantity + " Vaccine: " + slots[j].vname);
                                                    arr[l] = slots[j].vname;
                                                    slot_days[l] = slots[j].sday;
                                                    l++;
                                                    r++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(l == 0) {
                                System.out.println("No Slots Available!");
                                continue label;
                            }
                            if (l > 0) {
                                int choose = sc.nextInt();
                                for (int k = 0; k < ccount; k++) {
                                    if (Objects.equals(puid, citizens[k].cunique_id)) {
                                        System.out.println(citizens[k].cname + " vaccinated with " + arr[choose]);
                                        citizens[k].vaccine_name(arr[choose]);
                                        citizens[k].add_doses_given();
                                        citizens[k].add_slot_day(slot_days[choose]);
                                        for (int a = 0; a < scount; a++){
                                            if (id == slots[a].shid && Objects.equals(arr[choose], slots[a].vname)) {
                                                slots[a].squantity = slots[a].squantity - 1;
                                            }
                                        }
                                        for (int j = 0; j < vcount; j++) {
                                            if (Objects.equals(vaccines[j].vname, citizens[k].cvname)) {
                                                if (citizens[k].cdoses == vaccines[j].vdoses) {
                                                    citizens[k].cstatus = "FULLY VACCINATED";
                                                } else if (citizens[k].cdoses > 0 && citizens[k].cdoses < vaccines[j].vdoses) {
                                                    citizens[k].cstatus = "PARTIALLY VACCINATED";
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (r == 0){
                                System.out.println("This Hospital ID does not exist!");
                            }
                        } else {
                            System.out.println("The Slot for this Vaccine does not exist!");
                        }
                    } else if (option == 3) {
                        continue label;
                    } else {
                        System.out.println("Please enter a valid option!");
                    }
                } else {
                    System.out.println("This Citizen does not exist!");
                }
            } else if (input == 6) {
                System.out.print("Enter Hospital ID: ");
                int id = sc.nextInt();
                int val = 0;
                for (int i = 0; i < hcount; i++){
                    if(hospitals[i].hunique_id == id){
                        val++;
                        break;
                    }
                }
                if(val > 0) {
                    for (int j = 0; j < scount; j++) {
                        if (id == slots[j].shid) {
                            System.out.println("Day: " + slots[j].sday + ", Vaccine: " + slots[j].vname + ", Available Qty: " + slots[j].squantity);
                        }
                    }
                }
            } else if (input == 7) {
                System.out.print("Enter Patient ID: ");
                String pid = s.next();
                int val = 0;
                for (int i = 0; i < ccount; i++) {
                    if (Objects.equals(pid, citizens[i].cunique_id)) {
                        val++;
                    }
                }
                if (val > 0){
                    for (int i = 0; i < ccount; i++) {
                        if (Objects.equals(pid, citizens[i].cunique_id)) {
                            citizens[i].status();
                            if (!Objects.equals(citizens[i].cstatus, "REGISTERED")) {
                                System.out.println("Vaccine Given: " + citizens[i].cvname);
                                System.out.println("Number of Doses given: " + citizens[i].cdoses);
                                if (Objects.equals(citizens[i].cstatus, "FULLY VACCINATED")) {
                                    continue label;
                                } else {
                                    for (int j = 0; j < vcount; j++) {
                                        if (Objects.equals(vaccines[j].vname, citizens[i].cvname)) {
                                            System.out.println("Next Dose due date: " + (citizens[i].cslot + vaccines[j].vgap));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else{
                    System.out.println("This Citizen does not exist!");
                }
            } else {
                System.out.println("Please enter a valid task!");
            }
        }
    sc.close();
    s.close();

    }
}






