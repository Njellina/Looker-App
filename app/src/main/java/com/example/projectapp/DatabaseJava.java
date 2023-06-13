package com.example.projectapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.Objects;

public class DatabaseJava extends SQLiteOpenHelper{
    Context context;
    public static final String Table_Applicant = "Applicant";
    public static final String Table_Company = "Company";
    public static final String Table_Jobs = "Jobs";
    public static final String Table_History = "History";
    public static final String Table_Applicators = "Applicators";
    public static final String Table_ClosedJobs = "ClosedJobs";
    public static final String Table_CV = "CV";
    public static final String Table_Status = "Status";
    public static final String Table_Bio = "Bio";
    public static final String ID = "Id";
    public static final String EMAIL = "email";
    public static final String EMAILAPL = "emailapl";
    public static final String EMAILCOM = "emailcom";
    public static final String USERNAME = "name";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String ADDRESS = "address";
    public static final String CATEGORY = "category";
    public static final String CITY = "city";
    public static final String DESCRIPTION = "description";
    public static final String SALARY = "salary";
    public static final String PHOTO = "photo";
    public static final String STATUSS = "statuss";
    public static final String NAME = "name";
    public static final String COMNAME = "comname";
    public static final String BIO = "bio";
    public static final String JOBEXP = "jobexp";
    public static String NAME1 = "name";

    public DatabaseJava(Context context) {
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Company(id INTEGER primary key autoincrement, name TEXT, email TEXT, password TEXT, phone TEXT, address TEXT)");
        MyDB.execSQL("create Table Applicant(id INTEGER primary key autoincrement, name TEXT, email TEXT, password TEXT, phone TEXT, address TEXT)");
        MyDB.execSQL("create Table Jobs(id INTEGER primary key autoincrement, email TEXT, name TEXT, category TEXT, city TEXT, description TEXT, salary INT)");
        MyDB.execSQL("create Table History(id INTEGER primary key autoincrement, emailapl TEXT, emailcom TEXT, name TEXT, category TEXT, city TEXT, salary INT)");
        MyDB.execSQL("create Table Applicators(id INTEGER primary key autoincrement, emailcom TEXT, emailapl TEXT, name TEXT, category TEXT)");
        MyDB.execSQL("create Table ClosedJobs(id INTEGER primary key autoincrement, email TEXT, name TEXT, category TEXT, city TEXT, description TEXT, salary INT)");
        MyDB.execSQL("create Table CV(id INTEGER primary key autoincrement, email TEXT, name TEXT, photo BLOB)");
        MyDB.execSQL("create Table Status(id INTEGER primary key autoincrement, name TEXT, emailapl TEXT, category TEXT, comname TEXT, statuss TEXT)");
        MyDB.execSQL("create Table Bio(id INTEGER primary key autoincrement, email TEXT, bio TEXT, jobexp TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists Company");
        MyDB.execSQL("drop Table if exists Applicant");
        MyDB.execSQL("drop Table if exists Jobs");
        MyDB.execSQL("drop Table if exists History");
        MyDB.execSQL("drop Table if exists Applicators");
        MyDB.execSQL("drop Table if exists ClosedJobs");
        MyDB.execSQL("drop Table if exists CV");
        MyDB.execSQL("drop Table if exists Status");
        MyDB.execSQL("drop Table if exists Bio");
        onCreate(MyDB);
    }


    //------------------------------------------------------------INSERTING DATA

    public Boolean insertDataCompany(String name, String email, String password, String phone, String address){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        contentValues.put("address", address);
        long result = MyDB.insert("Company", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataApplicant(String name, String email, String password, String phone, String address){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        contentValues.put("address", address);
        long result = MyDB.insert("Applicant", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataJobs(String email, String name, String category, String city, String description, int salary){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("name", name);
        contentValues.put("category", category);
        contentValues.put("city", city);
        contentValues.put("description", description);
        contentValues.put("salary", salary);
        long result = MyDB.insert("Jobs", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataClosedJobs(String email, String name, String category, String city, String description, int salary){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("name", name);
        contentValues.put("category", category);
        contentValues.put("city", city);
        contentValues.put("description", description);
        contentValues.put("salary", salary);
        long result = MyDB.insert("ClosedJobs", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataHistory(String emailapl, String emailcom, String name, String category, String city, int salary){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emailapl", emailapl);
        contentValues.put("emailcom", emailcom);
        contentValues.put("name", name);
        contentValues.put("category", category);
        contentValues.put("city", city);
        contentValues.put("salary", salary);
        long result = MyDB.insert("History", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataApplicators(String emailcom, String emailapl, String name, String category){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emailcom", emailcom);
        contentValues.put("emailapl", emailapl);
        contentValues.put("name", name);
        contentValues.put("category", category);
        long result = MyDB.insert("Applicators", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataCV(String name, String email, String photo){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("photo", String.valueOf(photo));
        long result = MyDB.insert("CV", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataStatus(String name, String emailapl, String category, String comname, String statuss){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("emailapl", emailapl);
        contentValues.put("category", category);
        contentValues.put("comname", comname);
        contentValues.put("statuss", statuss);
        long result = MyDB.insert("Status", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataBio(String email, String bio, String jobexp){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("bio", bio);
        contentValues.put("jobexp", jobexp);
        long result = MyDB.insert("Bio", null, contentValues);
        if (result == -1) return false;
        else return true;
    }


    //------------------------------------------------------------CHECKING DATA

    public Boolean checkEmailCompany(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Company where email = ?", new String[] {email});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkLoginCompany(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Company where email = ? and password = ?", new String[] {email, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkEmailApplicant(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Applicant where email = ?", new String[] {email});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkLoginApplicant(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Applicant where email = ? and password = ?", new String[] {email, password});
        NAME1 = email;
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkAdmin(String AdminID, String AdminCode){
        SQLiteDatabase db = this.getWritableDatabase();
        if (Objects.equals(AdminID, "4dmin") && Objects.equals(AdminCode, "admin123")){
            return true;
        }
        else return false;
    }

    public Boolean checkJobID(String id, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Jobs where id = ? and email = ?", new String[] {id, email});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkClosedJobID(String id, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from ClosedJobs where id = ? and email = ?", new String[] {id, email});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkCVApplicant(String nama, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Applicant where name = ? and email = ?", new String[] {nama, email});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkCV(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from CV where email = ?", new String[] {email});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkApplicator(String emailcom, String emailapl){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Applicators where emailcom = ? and emailapl = ?", new String[] {emailcom, emailapl});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean checkBioData(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Bio where email = ?", new String[] {email});
        if (cursor.getCount() > 0) return true;
        else return false;
    }


    //------------------------------------------------------------SELECTING DATA

    public Cursor DataApplicant(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Applicant", null);
        return  cursor;
    }

    public Cursor DataCompany(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Company", null);
        return  cursor;
    }

    public Cursor DataJobs(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Jobs", null);
        return  cursor;
    }

    public Cursor DataBio(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Bio", null);
        return  cursor;
    }

    public Cursor DataHistory(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from History", null);
        return  cursor;
    }

    public Cursor DataApplicators(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Applicators", null);
        return  cursor;
    }

    public Cursor DataClosedJobs(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from ClosedJobs", null);
        return  cursor;
    }


    //------------------------------------------------------------DELETING DATA

    public void deleteAllApplicant(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from Applicant");
    }

    public void deleteAllCompany(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from Company");
    }

    public void deleteAllJobs(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from Jobs");
    }

    public void deleteAllHistory(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from History");
    }

    public void deleteAllApplicators(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from Applicators");
    }

    void deleteDataApplicant(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(Table_Applicant, "email = ?", new String[] {email});

        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteDataCompany(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(Table_Company, "email = ?", new String[] {email});

        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteDataJobs(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(Table_Jobs, "id = ?", new String[] {id});

        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteDataClosedJobs(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(Table_ClosedJobs, "id = ?", new String[] {id});

        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteDataCV(String email){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(Table_CV, "email = ?", new String[] {email});

        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteDataApplicator(String emailcom, String emailapl){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(Table_Applicators, "emailcom = ? and emailapl = ?", new String[] {emailcom, emailapl});

        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
        }
    }


    //------------------------------------------------------------SEARCHING DATA

    public Cursor searchApplicant(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {USERNAME, EMAIL, PASSWORD, PHONE, ADDRESS};
        Cursor cursor = db.query(Table_Applicant, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchCompany(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {USERNAME, EMAIL, PASSWORD, PHONE, ADDRESS};
        Cursor cursor = db.query(Table_Company, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor ApplicantUsername(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {USERNAME};
        Cursor cursor = db.query(Table_Applicant, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor ApplicantProfile(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {USERNAME, EMAIL, PHONE, ADDRESS};
        Cursor cursor = db.query(Table_Applicant, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor CompanyUsername(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {USERNAME};
        Cursor cursor = db.query(Table_Company, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor CompanyProfile(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {USERNAME, EMAIL, PHONE, ADDRESS};
        Cursor cursor = db.query(Table_Company, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchJobList(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {ID, CATEGORY, CITY, DESCRIPTION, SALARY};
        Cursor cursor = db.query(Table_Jobs, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchClosedJobList(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {ID, CATEGORY, CITY, DESCRIPTION, SALARY};
        Cursor cursor = db.query(Table_ClosedJobs, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchJobInformation(String name, String category, String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {EMAIL, DESCRIPTION};
        Cursor cursor = db.query(Table_Jobs, columns, "name = ? and category = ? and salary = ?", new String[] {name, category, salary}, null, null, null, null);
        return cursor;
    }

    public Cursor searchHistory(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {CATEGORY, USERNAME, EMAILCOM, CITY, SALARY};
        Cursor cursor = db.query(Table_History, columns, "emailapl = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchStatus(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {NAME, EMAILAPL, CATEGORY, COMNAME, STATUSS};
        Cursor cursor = db.query(Table_Status, columns, "emailapl = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchJobtoClosedJob(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {EMAIL, NAME, CATEGORY, CITY, DESCRIPTION, SALARY};
        Cursor cursor = db.query(Table_Jobs, columns, "id = ?", new String[] {ID}, null, null, null, null);
        return cursor;
    }

    public Cursor searchClosedJobtoJob(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {EMAIL, NAME, CATEGORY, CITY, DESCRIPTION, SALARY};
        Cursor cursor = db.query(Table_ClosedJobs, columns, "id = ?", new String[] {ID}, null, null, null, null);
        return cursor;
    }

    public Cursor searchCV(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {PHOTO};
        Cursor cursor = db.query(Table_CV, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchApplicators(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {NAME, EMAILAPL, CATEGORY};
        Cursor cursor = db.query(Table_Applicators, columns, "emailcom = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }

    public Cursor searchApplicatorsCom(String emailcom, String emailapl){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {EMAILAPL, NAME, CATEGORY};
        Cursor cursor = db.query(Table_Applicators, columns, "emailcom = ? and emailapl = ?", new String[] {emailcom, emailapl}, null, null, null, null);
        return cursor;
    }

    public Cursor searchBio(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] {BIO, JOBEXP};
        Cursor cursor = db.query(Table_Bio, columns, "email = ?", new String[] {email}, null, null, null, null);
        return cursor;
    }



    //------------------------------------------------------------UPDATING DATA

    public void updateDataJobs(String id, String email, String category, String city, String description, int salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CATEGORY, category);
        values.put(CITY, city);
        values.put(DESCRIPTION, description);
        values.put(SALARY, salary);

        long result = db.update(Table_Jobs, values, "ID = ? and EMAIL = ?", new String[]{id, email});
        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Update Successful!", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateDataBio(String email, String bio, String jobexp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BIO, bio);
        values.put(JOBEXP, jobexp);

        long result = db.update(Table_Bio, values, "EMAIL = ?", new String[]{email});
        if (result == -1){
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Update Successful!", Toast.LENGTH_SHORT).show();
        }
    }


    //------------------------------------------------------------ORDERING DATA

    public Cursor DescJobsSalary(int salary){
        SQLiteDatabase db = this.getWritableDatabase();

        String[] columns = new String[] {CATEGORY, CITY, SALARY};
        Cursor cursor = db.query(Table_Jobs, columns, null, null, null, null, salary+ " DESC");
        return cursor;
    }

    public Cursor AscJobsSalary(int salary){
        SQLiteDatabase db = this.getWritableDatabase();

        String[] columns = new String[] {CATEGORY, CITY, SALARY};
        Cursor cursor = db.query(Table_Jobs, columns, null, null, null, null, salary+ " ASC");
        return cursor;
    }

}
