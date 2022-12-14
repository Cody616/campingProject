import java.util.ArrayList;
import java.util.UUID;

public class CounselorList {
    private ArrayList<Counselor> counselors = new ArrayList<Counselor>();
    private static CounselorList counselorList;

    private CounselorList() {
        counselors = DataLoader.loadCounselors();
    }

    public static CounselorList getInstance() {
        if (counselorList == null) {
            counselorList = new CounselorList();
        }
        return counselorList;
    }

    public boolean addCounselor(Counselor counselor) {
        if (counselor == null) {
            return false;
        } else {
            counselors.add(counselor);
            saveCounselor();
            return true;
        }
    }

    // returns a counselor in the list with the given userName
    public Counselor getCounselorByUserName(String userName) {
        for (Counselor c : counselors) {
            if (c.getUserLogin().getUserName().equals(userName))
                return c;
        }
        return null;
    }

    public Counselor getCounselorByName(String firstName, String lastName) {
        for (Counselor c : counselors) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        return null;
    }

    public Counselor getCounselorByUUID(UUID uuid) {
        for (Counselor c : counselors) {
            if (c.getUUID().equals(uuid))
                return c;
        }
        return null;
    }

    public boolean haveCounselor(String userName, String password) {
        for (Counselor counselor : counselors) {
            if (counselor.getUserName().equals(userName)
                    && counselor.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }

    public void saveCounselor() {
        DataWriter.saveCounselors();
    }

    public ArrayList<Counselor> getCounselors() {
        return counselors;
    }
}