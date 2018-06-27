package developer.roy.animesh.reclyclerviewgridanimation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import developer.roy.animesh.reclyclerviewgridanimation.Adapter.SimpleRecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    Button btnSlideFromRight;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSlideFromRight = (Button)findViewById(R.id.btnRight);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        btnSlideFromRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAnimation(recyclerView, 2);
            }
        });


    }
    private void runAnimation(RecyclerView recyclerView, int type){
        Context context = recyclerView.getContext();
        LayoutAnimationController controller = null;

        if (type == 2)
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slide_from_right);

        SimpleRecyclerAdapter adapter = new SimpleRecyclerAdapter();
        recyclerView.setAdapter(adapter);

       recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
