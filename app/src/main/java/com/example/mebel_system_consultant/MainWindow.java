package com.example.mebel_system_consultant;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mebel_system_consultant.api_serializer.Category;
import com.example.mebel_system_consultant.api_serializer.Consultant;
import com.example.mebel_system_consultant.api_serializer.Filial;
import com.example.mebel_system_consultant.api_serializer.Name_furniture;
import com.example.mebel_system_consultant.api_serializer.UserInfo;
import com.example.mebel_system_consultant.api_serializer.Visitors;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainWindow extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public int counter = 1;
    public Context activity;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SwitchCompat switchCompat2 = findViewById(R.id.switch_2);
        final SwitchCompat switchCompat3 = findViewById(R.id.switch_3);
        final SwitchCompat switchCompat4 = findViewById(R.id.switch_4);
        final SwitchCompat switchCompat5 = findViewById(R.id.switch_5);


        final Spinner spinnercategory = findViewById(R.id.spinnerKategoriya);
        final EditText name_furniture = findViewById(R.id.editTextNaimenovaniye);
        final Spinner spinnercategory2 = findViewById(R.id.spinnerKategoriya2);
        final EditText name_furniture2 = findViewById(R.id.editTextNaimenovaniye2);
        final Spinner spinnercategory3 = findViewById(R.id.spinnerKategoriya3);
        final EditText name_furniture3 = findViewById(R.id.editTextNaimenovaniye3);
        final Spinner spinnercategory4 = findViewById(R.id.spinnerKategoriya4);
        final EditText name_furniture4 = findViewById(R.id.editTextNaimenovaniye4);
        final Spinner spinnercategory5 = findViewById(R.id.spinnerKategoriya5);
        final EditText name_furniture5 = findViewById(R.id.editTextNaimenovaniye5);



        final LinearLayout linearLayoutCategoryGroup = findViewById(R.id.categorygroup);
        final LinearLayout linearLayoutHorizontalGroup = findViewById(R.id.categorygrouphorizontal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        final EditText eText;

        eText = findViewById(R.id.editTextData);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog picker;
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainWindow.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                if (dayOfMonth < 10) {
                                    eText.setText(year + "-" + (monthOfYear + 1) + "-" + ("0" + dayOfMonth));
                                } else {
                                    eText.setText(year + "-" + (monthOfYear + 1) + "-" + (dayOfMonth));
                                }


                            }
                        }, year, month, day);
                picker.show();
            }
        });


        final EditText datas = eText;
        final Spinner filial = findViewById(R.id.spinnerFilial);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.filials, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filial.setAdapter(adapter);
        final Spinner otkudauznal = findViewById(R.id.spinnerOtkudaUznal);
        final ArrayAdapter<CharSequence> adapterotkudauznal = ArrayAdapter.createFromResource(this, R.array.otkudauznal, R.layout.spinner_item);
        adapterotkudauznal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        otkudauznal.setAdapter(adapterotkudauznal);
        final EditText title = findViewById(R.id.editTextName);
        final EditText body = findViewById(R.id.editTextPhone);
        final Spinner xarakter = findViewById(R.id.spinnerXarakter);
        final ArrayAdapter<CharSequence> adapterxarakter = ArrayAdapter.createFromResource(this, R.array.xarakter, R.layout.spinner_item);
        adapterxarakter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        xarakter.setAdapter(adapterxarakter);

        final Spinner status = findViewById(R.id.spinnerStatus);
        final ArrayAdapter<CharSequence> adapterstatus = ArrayAdapter.createFromResource(this, R.array.status, R.layout.spinner_item);
        adapterstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(adapterstatus);
        final EditText drugiemagazine = findViewById(R.id.editTextDrugiemagazini);

        final Spinner category = findViewById(R.id.spinnerKategoriya);
        final Spinner category2 = spinnercategory2;
        final Spinner category3 = spinnercategory3;
        final Spinner category4 = spinnercategory4;
        final Spinner category5 = spinnercategory5;

        final ArrayAdapter<CharSequence> adapterkategoriya = ArrayAdapter.createFromResource(this, R.array.kategoriya, R.layout.spinner_item);
        adapterkategoriya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapterkategoriya);
        category2.setAdapter(adapterkategoriya);
        category3.setAdapter(adapterkategoriya);
        category4.setAdapter(adapterkategoriya);
        category5.setAdapter(adapterkategoriya);



        final EditText naimenovaniye = findViewById(R.id.editTextNaimenovaniye);


        final Spinner tipmodeli = findViewById(R.id.spinnerTipModeli);
        final ArrayAdapter<CharSequence> adaptertipmodeli = ArrayAdapter.createFromResource(this, R.array.tipmodeli, R.layout.spinner_item);
        adaptertipmodeli.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipmodeli.setAdapter(adaptertipmodeli);


        final EditText svet = findViewById(R.id.editTextSvet);
        final EditText nuansi = findViewById(R.id.editTextNyuansi);
        final Spinner konsultant = findViewById(R.id.spinnerKonsultant);
        final ArrayAdapter<CharSequence> adapterkonsultant = ArrayAdapter.createFromResource(this, R.array.konsultants, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        konsultant.setAdapter(adapterkonsultant);

        SwitchCompat switch_1 = findViewById(R.id.switch_1);
        SwitchCompat switch_2 = findViewById(R.id.switch_2);
        SwitchCompat switch_3 = findViewById(R.id.switch_3);
        SwitchCompat switch_4 = findViewById(R.id.switch_4);
        SwitchCompat switch_5 = findViewById(R.id.switch_5);

        List<SwitchCompat> switches = new ArrayList<>();
        switches.add(switch_1);
        switches.add(switch_2);
        switches.add(switch_3);
        switches.add(switch_4);
        switches.add(switch_5);

        for (int i = 0; i < switches.size(); i++) {
            switches.get(i).setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                Toast.makeText(MainWindow.this,
                                        "Купил", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainWindow.this,
                                        "Не купил", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }


        final Button addcategory = findViewById(R.id.addcategory);
        final Button delete_category = findViewById(R.id.deletecategory);
        addcategory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                counter++;
                if (counter >= 2) {
                    delete_category.setVisibility(View.VISIBLE);
                }
                if (counter == 2) {
                    spinnercategory2.setVisibility(View.VISIBLE);
                    name_furniture2.setVisibility(View.VISIBLE);
                    switchCompat2.setVisibility(View.VISIBLE);
                }
                if (counter == 3) {
                    spinnercategory3.setVisibility(View.VISIBLE);
                    name_furniture3.setVisibility(View.VISIBLE);
                    switchCompat3.setVisibility(View.VISIBLE);
                }

                if (counter == 4) {
                    spinnercategory4.setVisibility(View.VISIBLE);
                    name_furniture4.setVisibility(View.VISIBLE);
                    switchCompat4.setVisibility(View.VISIBLE);
                }

                if (counter == 5) {
                    spinnercategory5.setVisibility(View.VISIBLE);
                    name_furniture5.setVisibility(View.VISIBLE);
                    switchCompat5.setVisibility(View.VISIBLE);
                }

            }
        });


        delete_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (counter) {
                    case 2:
                        spinnercategory2.setVisibility(View.GONE);
                        name_furniture2.setVisibility(View.GONE);
                        counter--;
                        delete_category.setVisibility(View.GONE);
                        switchCompat2.setVisibility(View.GONE);
                        break;
                    case 3:
                        spinnercategory3.setVisibility(View.GONE);
                        name_furniture3.setVisibility(View.GONE);
                        switchCompat3.setVisibility(View.GONE);
                        counter--;
                        break;
                    case 4:
                        spinnercategory4.setVisibility(View.GONE);
                        name_furniture4.setVisibility(View.GONE);
                        switchCompat4.setVisibility(View.GONE);
                        counter--;
                        break;
                    case 5:
                        spinnercategory5.setVisibility(View.GONE);
                        name_furniture5.setVisibility(View.GONE);
                        switchCompat5.setVisibility(View.GONE);
                        counter--;
                        break;
                    case 6:
                        spinnercategory5.setVisibility(View.GONE);
                        name_furniture5.setVisibility(View.GONE);
                        switchCompat5.setVisibility(View.GONE);
                        counter=4;
                        break;
                    case 7:
                        spinnercategory5.setVisibility(View.GONE);
                        name_furniture5.setVisibility(View.GONE);
                        switchCompat5.setVisibility(View.GONE);
                        counter=4;
                        break;
                    case 8:
                        spinnercategory5.setVisibility(View.GONE);
                        name_furniture5.setVisibility(View.GONE);
                        switchCompat5.setVisibility(View.GONE);
                        counter=4;
                        break;
                    case 9:
                        spinnercategory5.setVisibility(View.GONE);
                        name_furniture5.setVisibility(View.GONE);
                        switchCompat5.setVisibility(View.GONE);
                        counter=4;
                        break;
                }

            }
        });


        final Button sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtn.setEnabled(true);
                Filial filal = new Filial(filial.getSelectedItem().toString());
                Consultant consultant = new Consultant(konsultant.getSelectedItem().toString());
                Name_furniture[] name_furnitures = new Name_furniture[5];
                Category[] categories = new Category[5];
                name_furnitures[0] = new Name_furniture(name_furniture.getText().toString());

                categories[0] = new Category(category.getSelectedItem().toString());
                if (category2.getVisibility() == View.VISIBLE && name_furniture2.getVisibility() == View.VISIBLE) {
                    categories[1] = new Category(category2.getSelectedItem().toString());
                    name_furnitures[1] = new Name_furniture(name_furniture2.getText().toString());
                }
                if (category3.getVisibility() == View.VISIBLE && name_furniture3.getVisibility() == View.VISIBLE) {
                    categories[2] = new Category(category3.getSelectedItem().toString());
                    name_furnitures[2] = new Name_furniture(name_furniture3.getText().toString());
                }
                if (category4.getVisibility() == View.VISIBLE && name_furniture4.getVisibility() == View.VISIBLE) {
                    categories[3] = new Category(category4.getSelectedItem().toString());
                    name_furnitures[3] = new Name_furniture(name_furniture4.getText().toString());
                }
                if (category5.getVisibility() == View.VISIBLE && name_furniture3.getVisibility() == View.VISIBLE) {
                    categories[4] = new Category(category5.getSelectedItem().toString());
                    name_furnitures[4] = new Name_furniture(name_furniture5.getText().toString());
                }
                int nullcounter = 0;
                for (int i = 0; i < categories.length; i++) {
                    if (categories[i] == null) {
                        nullcounter++;
                    }
                }
                Name_furniture[] name_furnitures2 = new Name_furniture[5-nullcounter];
                Category[] categories2 = new Category[5-nullcounter];
                for (int i=0;i<categories2.length;i++){
                    categories2[i]=categories[i];
                    name_furnitures2[i]=name_furnitures[i];
                }

                Visitors[] vis = new Visitors[1];
                vis[0] = new Visitors(datas.getText().toString(),
                        otkudauznal.getSelectedItem().toString(),
                        filal,
                        tipmodeli.getSelectedItem().toString(),
                        consultant,
                        svet.getText().toString(),
                        tipmodeli.getSelectedItem().toString(),
                        nuansi.getText().toString(),
                        name_furnitures2,
                        drugiemagazine.getText().toString(),
                        categories2);
                UserInfo user = new UserInfo(
                        vis,
                        xarakter.getSelectedItem().toString(),
                        nuansi.getText().toString(),
                        title.getText().toString(),
                        body.getText().toString(),
                        status.getSelectedItem().toString()
                );
                if (title.length() == 0) {
                    title.requestFocus();
                    title.setError("Пожалуйста заполните поле ");
                } else if (nuansi.length() == 0) {
                    nuansi.requestFocus();
                    nuansi.setError("Пожалуйста заполните поле ");
                } else if (body.length() == 0) {
                    body.setText("-");

                } else if (naimenovaniye.length() == 0) {
                    naimenovaniye.setText("-");
                } else if (svet.length() == 0) {
                    svet.setText("-");
                } else if (drugiemagazine.length() == 0) {
                    drugiemagazine.setText("-");
                } else if (filial.getSelectedItem().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(MainWindow.this, "Заполните поля Филиала  ", Toast.LENGTH_SHORT);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toastMessage.setTextColor(Color.rgb(255, 135, 135));
                    toast.show();

                } else if (otkudauznal.getSelectedItem().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(MainWindow.this, "Заполните поля Откуда  ", Toast.LENGTH_SHORT);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toastMessage.setTextColor(Color.rgb(255, 135, 135));
                    toast.show();
                } else if (xarakter.getSelectedItem().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(MainWindow.this, "Заполните поля Характера   ", Toast.LENGTH_SHORT);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toastMessage.setTextColor(Color.rgb(255, 135, 135));
                    toast.show();
                } else if (status.getSelectedItem().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(MainWindow.this, "Заполните поля Статуса  ", Toast.LENGTH_SHORT);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toastMessage.setTextColor(Color.rgb(255, 135, 135));
                    toast.show();
                } else if (category.getSelectedItem().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(MainWindow.this, "Заполните поля Категории  ", Toast.LENGTH_SHORT);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toastMessage.setTextColor(Color.rgb(255, 135, 135));
                    toast.show();
                } else if (tipmodeli.getSelectedItem().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(MainWindow.this, "Заполните поля Тип модели ", Toast.LENGTH_SHORT);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toastMessage.setTextColor(Color.rgb(255, 135, 135));
                    toast.show();
                } else if (konsultant.getSelectedItem().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(MainWindow.this, "Заполните поля Консультанта", Toast.LENGTH_SHORT);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toastMessage.setTextColor(Color.rgb(255, 135, 135));
                    toast.show();
                } else {

                    sendNetworkRequest(user);

                }


            }


            private void sendNetworkRequest(UserInfo user) {

                Toast.makeText(MainWindow.this, "Отправляется", Toast.LENGTH_SHORT).show();
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("http://ac07df84.ngrok.io/api/customer/")
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();

                UserClient client = retrofit.create(UserClient.class);
                Call<UserInfo> call = client.createAccaount(user);
                call.enqueue(new Callback<UserInfo>() {
                    @Override
                    public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                        if (response.isSuccessful()) {
                            String responsestring = response.message().toString();
                            Toast.makeText(MainWindow.this, responsestring, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserInfo> call, Throwable t) {
                        Toast.makeText(MainWindow.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }


        });


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent myIntent = new Intent(MainWindow.this, ListView.class);

        myIntent.putExtra("item", item.toString());
        MainWindow.this.startActivity(myIntent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.history:
                Intent myIntent = new Intent(MainWindow.this, DetailsOfClients.class);
                myIntent.putExtra("item", "Себзор");
                MainWindow.this.startActivity(myIntent);
                break;

            case R.id.selled_mebel:
                Intent myIntent1 = new Intent(MainWindow.this, ListView.class);
                myIntent1.putExtra("item", "Хамза");
                MainWindow.this.startActivity(myIntent1);
                break;

            case R.id.night_mode:
                Intent myIntent2 = new Intent(MainWindow.this, ListView.class);
                myIntent2.putExtra("item", "Октепа");
                MainWindow.this.startActivity(myIntent2);
                break;

            case R.id.settings:
                Intent myIntent3 = new Intent(MainWindow.this, ListView.class);
                myIntent3.putExtra("item", "vsemagazini");
                MainWindow.this.startActivity(myIntent3);
                break;

        }


        return true;
    }
}
