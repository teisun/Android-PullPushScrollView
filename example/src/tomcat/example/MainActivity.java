package tomcat.example;

import tomcat.example.PullPushLayout.OnTouchEventMoveListenre;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
	
	private View btnBack;
	private View btnShare;		//标题分享
	private View navBar;
	private View lineNavBar;

	private PullPushLayout mLayout;
	private Drawable bgBackDrawable;
	private Drawable bgShareDrawable;
	private Drawable bgNavBarDrawable;
	private Drawable bglineNavBarDrawable;
	
	private int alphaMax = 180;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

	private void initView() {
		mLayout = (PullPushLayout) this.findViewById(R.id.layout);
		mLayout.setOnTouchEventMoveListenre(new OnTouchEventMoveListenre() {

			@Override
			public void onSlideUp(int mOriginalHeaderHeight, int mHeaderHeight) {
				
			}

			@Override
			public void onSlideDwon(int mOriginalHeaderHeight, int mHeaderHeight) {
				
			}

			@Override
			public void onSlide(int alpha) {
				int alphaReverse = alphaMax - alpha;
				if (alphaReverse < 0) {
					alphaReverse = 0;
				}
				bgBackDrawable.setAlpha(alphaReverse);
				bgShareDrawable.setAlpha(alphaReverse);
				bgNavBarDrawable.setAlpha(alpha);
				bglineNavBarDrawable.setAlpha(alpha);

			}
		});
		navBar = this.findViewById(R.id.nav_bar);
		lineNavBar = this.findViewById(R.id.line_nav_bar);
		btnBack = this.findViewById(R.id.iv_back);
		btnShare = this.findViewById(R.id.iv_share);
		bgBackDrawable = btnBack.getBackground();
		bgBackDrawable.setAlpha(alphaMax);
		bgShareDrawable = btnShare.getBackground();
		bgShareDrawable.setAlpha(alphaMax);
		bgNavBarDrawable = navBar.getBackground();
		bglineNavBarDrawable = lineNavBar.getBackground();
		bgNavBarDrawable.setAlpha(0);
		bglineNavBarDrawable.setAlpha(0);
		
	}
}
