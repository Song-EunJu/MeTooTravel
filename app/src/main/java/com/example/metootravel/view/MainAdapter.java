package com.example.metootravel.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metootravel.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    // list view 의 아이템들을 담을 arraylist
    private ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) { // listview가 생성될 때의 생명주기 onCreate()랑 비슷
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MainAdapter.CustomViewHolder holder, int position) { // 실제 추가될 땨 샹명주기
        holder.iv_image.setImageResource(arrayList.get(position).getIv_image()); // imageview 생성하는 애들을 가져오는 것
        holder.tv_title.setText(arrayList.get(position).getTv_title());
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ // 리스트뷰 클릭했을 때 작동하는 것
                String curName = holder.tv_title.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size():0);
    }

    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position); // 리스트뷰를 지우고 새로고침해주는 코드
        } catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iv_image;
        protected TextView tv_title;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
