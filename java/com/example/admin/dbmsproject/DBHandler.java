package com.example.admin.dbmsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sahil Jain on 10-04-2018.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "DATABASE";
    private static final String CUSTOMERS = "Customers";
    private static final String RESTAURANTS = "Restaurants";
    private static final String MOVIES = "Movies";
    private static final String TOURIST_PLACE = "TouristPlaces";


    private static final String C_NAME = "Name";
    private static final String C_MOBILE = "Mobile";
    private static final String C_AGE = "Age";
    private static final String C_LOCALITY = "Locality";
    private static final String C_CITY = "City";

    private static final String R_NAME = "Name";
    private static final String R_COST = "Meal_for_One";
    private static final String R_CUISINE = "Cuisine";
    private static final String R_RATING = "Rating";

    private static final String M_NAME = "Name";
    private static final String M_COST = "Ticket_Cost";
    private static final String M_GENRE = "Genre";
    private static final String M_RATING = "Rating";

    private static final String T_NAME = "Name";
    private static final String T_COST = "Ticket_Cost";
    private static final String T_RATING = "Rating";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("ABCD","onCreate()");
        createTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d("ABCD","onUpgrade()");

        db.execSQL("DROP TABLE IF EXISTS " + CUSTOMERS);
        db.execSQL("DROP TABLE IF EXISTS " + RESTAURANTS);
        db.execSQL("DROP TABLE IF EXISTS " + MOVIES);
        db.execSQL("DROP TABLE IF EXISTS " + TOURIST_PLACE);
        onCreate(db);
    }

    private void createTable(SQLiteDatabase db){

        Log.d("ABCD","createTable()");

        String CREATE_CUSTOMERS_TABLE = "Create Table " + CUSTOMERS + "("
                + C_NAME + " Text,"
                + C_MOBILE + " Text,"
                + C_AGE + " Integer,"
                + C_LOCALITY + " Text,"
                + C_CITY + " Text,"
                + "Primary Key( " + C_MOBILE + "))";

        db.execSQL(CREATE_CUSTOMERS_TABLE);

        String CREATE_RESTAURANTS_TABLE = "Create Table " + RESTAURANTS + "("
                + R_NAME + " Text,"
                + R_COST + " Integer,"
                + R_CUISINE + " Text,"
                + R_RATING + " Integer,"
                + "Primary Key( " + R_NAME + "))";

        db.execSQL(CREATE_RESTAURANTS_TABLE);

        String CREATE_MOVIES_TABLE = "Create Table " + MOVIES + "("
                + M_NAME + " Text,"
                + M_COST + " Text,"
                + M_GENRE + " Text,"
                + M_RATING + " Text,"
                + "Primary Key( " + M_NAME + "))";

        db.execSQL(CREATE_MOVIES_TABLE);

        String CREATE_PLACES_TABLE = "Create Table " + TOURIST_PLACE + "("
                + T_NAME + " Text,"
                + T_COST + " Integer,"
                + T_RATING + " Integer,"
                + "Primary Key( " + T_NAME + "))";

        db.execSQL(CREATE_PLACES_TABLE);

    }

    public void insertData(){

        Log.d("ABCD","insertData()");
        deleteData();

        insertNewCustomer("Sahil Jain", "9643543402", "19", "Rohini", "New Delhi");
        insertNewCustomer("Utkarsh Rai", "8826318872", "19", "I.P. Extension", "New Delhi");
        insertNewCustomer("Saloni Gupta", "9810170595", "19", "Vikas Puri", "New Delhi");

        insertNewRestaurant("Dominos", "550", "Italian", "3");
        insertNewRestaurant("McDonalds", "200", "American", "2");
        insertNewRestaurant("BTW", "300", "Indian", "3");
        insertNewRestaurant("Moti Mahal Deluxe", "1600", "All", "5");
        insertNewRestaurant("Big Yellow Door", "600", "Indian", "4");

        insertNewMovie("Avengers: Infinity War", "350", "Sci-Fi", "9");
        insertNewMovie("Wolf of Wall Street", "350", "Biographical", "8");
        insertNewMovie("Django Unchained", "350", "Drama", "8");
        insertNewMovie("Padmaavat", "350", "Historical", "7");
        insertNewMovie("Baaghi 2", "350", "Action", "5");

        insertNewTP("Qutub Minar", "50", "6");
        insertNewTP("Akshardham", "100", "9");
        insertNewTP("National Museum", "100", "8");
        insertNewTP("Iskcon Temple", "50", "8");
        insertNewTP("Red Fort", "50", "8");

    }

    private void deleteData(){

        Log.d("ABCD", "deleteData()");

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + CUSTOMERS);
        db.execSQL("DELETE FROM " + RESTAURANTS);
        db.execSQL("DELETE FROM " + MOVIES);
        db.execSQL("DELETE FROM " + TOURIST_PLACE);

    }

    public void insertNewCustomer(String Name, String Mobile, String Age, String Locality, String City) {

        Log.d("ABCD","insertNewCustomer()");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(C_NAME, Name);
        values.put(C_MOBILE, Mobile);
        values.put(C_AGE, Age);
        values.put(C_LOCALITY, Locality);
        values.put(C_CITY, City);

        long val = db.insert(CUSTOMERS, null, values);
        Log.d("ABCD - Val", String.valueOf(val));

        db.close();
    }

    public void insertNewRestaurant(String Name, String Cost, String Cuisine, String Rating) {

        Log.d("ABCD","insertNewRestaurant()");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(R_NAME, Name);
        values.put(R_COST, Cost);
        values.put(R_CUISINE, Cuisine);
        values.put(R_RATING, Rating);

        long val = db.insert(RESTAURANTS, null, values);
        Log.d("ABCD - Val", String.valueOf(val));
        db.close();
    }

    public void insertNewMovie(String Name, String Cost, String Genre, String Rating) {

        Log.d("ABCD","insertNewMovie()");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(M_NAME, Name);
        values.put(M_COST, Cost);
        values.put(M_GENRE, Genre);
        values.put(M_RATING, Rating);

        long val = db.insert(MOVIES, null, values);
        Log.d("ABCD - Val", String.valueOf(val));
        db.close();
    }

    public void insertNewTP(String Name, String Cost, String Rating) {

        Log.d("ABCD","insertNewTP()");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(T_NAME, Name);
        values.put(T_COST, Cost);
        values.put(T_RATING, Rating);

        long val = db.insert(TOURIST_PLACE, null, values);
        Log.d("ABCD - Val", String.valueOf(val));
        db.close();
    }

    public String[][] getAllData(int low, int high){

        Log.d("ABCD","get_all_data()");

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + RESTAURANTS + " WHERE " + R_COST + " BETWEEN " + low + " AND " + high;
        String query1 = "SELECT * FROM " + MOVIES + ", " + TOURIST_PLACE + ", (" + query + ")";
        String query2 = query1 + " ORDER BY " + R_RATING + " DESC, " + M_RATING + " DESC";

        Cursor csr = db.rawQuery(query2, null);
        csr.moveToFirst();

        int row = csr.getCount();
        int column = csr.getColumnCount();

        String[][] data = new String[column][row];

        Log.d("ABCD - Column", String.valueOf(column));
        Log.d("ABCD - Row", String.valueOf(row));

        csr.moveToFirst();
        int i = 0, j=0;
        for (i=0; i<row;i++) {
            for(j=0; j<column; j++) {
                data[j][i] = csr.getString(j);
            }
            csr.moveToNext();
        }
        csr.close();
        db.close();

        return data;
    }

    public String[][] getAllCustomers(){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + CUSTOMERS;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String[][] customers = new String[5][count];
        int i = 0;
        while (count > 0) {
            customers[0][i] = csr.getString(0);
            customers[1][i] = csr.getString(1);
            customers[2][i] = csr.getString(2);
            customers[3][i] = csr.getString(3);
            customers[4][i] = csr.getString(4);

            i++;
            csr.moveToNext();
            count--;
        }
        csr.close();
        db.close();
        return customers;
    }

    public int getCustomerCount(){
        SQLiteDatabase db = this.getReadableDatabase();

        String count_query = "SELECT * FROM " + CUSTOMERS;
        Cursor csr = db.rawQuery(count_query,null);
        int count = csr.getCount();

        db.close();
        csr.close();

        return count;
    }

    public String[][] getAllRestaurants(){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + RESTAURANTS;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String[][] restaurants = new String[4][count];
        int i = 0;
        while (count > 0) {
            restaurants[0][i] = csr.getString(0);
            restaurants[1][i] = csr.getString(1);
            restaurants[2][i] = csr.getString(2);
            restaurants[3][i] = csr.getString(3);

            i++;
            csr.moveToNext();
            count--;
        }
        csr.close();
        db.close();
        return restaurants;
    }

    public int getRestaurantsCount(){
        SQLiteDatabase db = this.getReadableDatabase();

        String count_query = "SELECT * FROM " + RESTAURANTS;
        Cursor csr = db.rawQuery(count_query,null);
        int count = csr.getCount();

        db.close();
        csr.close();

        return count;
    }

    public String[][] getAllMovies(){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + MOVIES;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String[][] movies = new String[4][count];
        int i = 0;
        while (count > 0) {
            movies[0][i] = csr.getString(0);
            movies[1][i] = csr.getString(1);
            movies[2][i] = csr.getString(2);
            movies[3][i] = csr.getString(3);

            i++;
            csr.moveToNext();
            count--;
        }
        csr.close();
        db.close();
        return movies;
    }

    public int getMoviesCount(){
        SQLiteDatabase db = this.getReadableDatabase();

        String count_query = "SELECT * FROM " + MOVIES;
        Cursor csr = db.rawQuery(count_query,null);
        int count = csr.getCount();

        db.close();
        csr.close();

        return count;
    }

    public String[][] getAllTouristPlaces(){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TOURIST_PLACE;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String[][] touristPlaces = new String[3][count];
        int i = 0;
        while (count > 0) {
            touristPlaces[0][i] = csr.getString(0);
            touristPlaces[1][i] = csr.getString(1);
            touristPlaces[2][i] = csr.getString(2);

            i++;
            csr.moveToNext();
            count--;
        }
        csr.close();
        db.close();
        return touristPlaces;
    }

    public int getTouristPlacesCount(){
        SQLiteDatabase db = this.getReadableDatabase();

        String count_query = "SELECT * FROM " + TOURIST_PLACE;
        Cursor csr = db.rawQuery(count_query,null);
        int count = csr.getCount();

        db.close();
        csr.close();

        return count;
    }

    public String[][] getTrending(){
        SQLiteDatabase db = this.getReadableDatabase();

        String[][] trending = new String[4][5];
        int i = 0;

        String query = "SELECT * FROM " + RESTAURANTS + " ORDER BY " + R_RATING + " DESC";
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        while (i<2) {
            trending[0][i] = csr.getString(0);
            trending[1][i] = csr.getString(1);
            trending[2][i] = csr.getString(2);
            trending[3][i] = csr.getString(3);

            i++;
            csr.moveToNext();
        }

        query = "SELECT * FROM " + MOVIES + " ORDER BY " + M_RATING + " DESC";
        csr = db.rawQuery(query, null);
        csr.moveToFirst();
        while (i<4) {
            trending[0][i] = csr.getString(0);
            trending[1][i] = csr.getString(1);
            trending[2][i] = csr.getString(2);
            trending[3][i] = csr.getString(3);

            i++;
            csr.moveToNext();
        }

        query = "SELECT * FROM " + TOURIST_PLACE + " ORDER BY " + T_RATING + " DESC";
        csr = db.rawQuery(query, null);
        csr.moveToFirst();
        while (i<5) {
            trending[0][i] = csr.getString(0);
            trending[1][i] = csr.getString(1);
            trending[2][i] = csr.getString(2);

            i++;
            csr.moveToNext();
        }

        csr.close();
        db.close();
        return trending;
    }

    public String[][] getThingsNearMe(){
        SQLiteDatabase db = this.getReadableDatabase();

        String[][] thingsNearMe = new String[4][5];
        int i = 0;

        String query = "SELECT * FROM " + RESTAURANTS + " ORDER BY " + R_RATING + " DESC";
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        while (i<2) {
            thingsNearMe[0][i] = csr.getString(0);
            thingsNearMe[1][i] = csr.getString(1);
            thingsNearMe[2][i] = csr.getString(2);
            thingsNearMe[3][i] = csr.getString(3);

            i++;
            csr.moveToNext();
        }

        query = "SELECT * FROM " + MOVIES + " ORDER BY " + M_RATING + " DESC";
        csr = db.rawQuery(query, null);
        csr.moveToFirst();
        while (i<4) {
            thingsNearMe[0][i] = csr.getString(0);
            thingsNearMe[1][i] = csr.getString(1);
            thingsNearMe[2][i] = csr.getString(2);
            thingsNearMe[3][i] = csr.getString(3);

            i++;
            csr.moveToNext();
        }

        query = "SELECT * FROM " + TOURIST_PLACE + " ORDER BY " + T_RATING + " DESC";
        csr = db.rawQuery(query, null);
        csr.moveToFirst();
        while (i<5) {
            thingsNearMe[0][i] = csr.getString(0);
            thingsNearMe[1][i] = csr.getString(1);
            thingsNearMe[2][i] = csr.getString(2);

            i++;
            csr.moveToNext();
        }

        csr.close();
        db.close();
        return thingsNearMe;
    }

    /*
    public String[][] getAllData(int low, int high){

        Log.d("ABCD","get_all_data()");

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + RESTAURANTS + " WHERE " + R_COST + " BETWEEN " + low + " AND " + high;
        String query1 = "SELECT * FROM " + MOVIES + ", " + TOURIST_PLACE + ", (" + query + ")";

        Cursor csr = db.rawQuery(query1, null);
        csr.moveToFirst();

        int count = csr.getCount();
        String[][] data = new String[11][count];
        Log.d("ABCD - Count", String.valueOf(csr.getCount()));

        csr.moveToFirst();
        int i = 0;
        while (count > 0) {
            data[0][i] = csr.getString(0);
            data[1][i] = csr.getString(1);
            data[2][i] = csr.getString(2);
            data[3][i] = csr.getString(3);
            data[4][i] = csr.getString(4);
            data[5][i] = csr.getString(5);
            data[6][i] = csr.getString(6);
            data[7][i] = csr.getString(7);
            data[8][i] = csr.getString(8);
            data[9][i] = csr.getString(9);
            data[10][i] = csr.getString(10);

            Log.d("WXYZ - Data", data[0][i]);
            Log.d("WXYZ - Data", data[1][i]);
            Log.d("WXYZ - Data", data[2][i]);
            Log.d("WXYZ - Data", data[3][i]);
            Log.d("WXYZ - Data", data[4][i]);
            Log.d("WXYZ - Data", data[5][i]);
            Log.d("WXYZ - Data", data[6][i]);
            Log.d("WXYZ - Data", data[7][i]);
            Log.d("WXYZ - Data", data[8][i]);
            Log.d("WXYZ - Data", data[9][i]);
            Log.d("WXYZ - Data", data[10][i]);

            i++;
            csr.moveToNext();
            count--;
        }
        csr.close();
        db.close();

        return data;
    }
*/

}//DBHandler Class
