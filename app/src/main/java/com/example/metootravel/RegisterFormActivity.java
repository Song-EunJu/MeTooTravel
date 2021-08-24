package com.example.metootravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class RegisterFormActivity extends AppCompatActivity{

    private FirebaseAuth firebaseAuth; // firebase 인증
    private DatabaseReference databaseRef; // 실시간 데이터베이스
    private EditText email_edit, password_edit, password_confirm_edit; // 회원가입 입력 필드
    private Button basic_register; // 회원가입 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseRef = FirebaseDatabase.getInstance().getReference("MeTooTravel");

        email_edit = findViewById(R.id.email_edit);
        password_edit = findViewById(R.id.password_edit);
        password_confirm_edit = findViewById(R.id.password_confirm_edit);

        basic_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입 처리 시작 (입력한 이메일, 비밀번호 받아오기)
                String email = email_edit.getText().toString();
                String password = password_edit.getText().toString();

                // firebase
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterFormActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){ // 회원가입이 성공했을 때
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser(); // 현재 회원가입된 유저 가져옴
                            UserAccount account = new UserAccount();
                            account.setToken(firebaseUser.getUid());
                            account.setEmail(firebaseUser.getEmail());
                            account.setPassword(password);

                            // setValue : DB에 INSERT 하는 행위
                            databaseRef.child("userAccount").child(firebaseUser.getUid()).setValue(account);
                            Toast.makeText(RegisterFormActivity.this, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegisterFormActivity.this, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
