import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.behaviors.mouse.*;

//課題
public class Es5 extends JFrame{
	
	//司令塔
	public Es5(){
		getContentPane().setLayout( new BorderLayout() );
		
		//ハードウェア情報に基づいて設定を行う
		GraphicsConfiguration cfg = SimpleUniverse.getPreferredConfiguration();
		
		//3D描画領域
		//ContentPaneはJframeの表示領域のこと
		Canvas3D canvas3d = new Canvas3D( cfg );
		getContentPane().add( "Center", canvas3d );
		

		//仮想空間:カメラ自動設置
		SimpleUniverse univ = new SimpleUniverse( canvas3d );
		univ.getViewingPlatform().setNominalViewingTransform();
		
		//--------プリミティブつくって登録部分--------
		BranchGroup Pri = construct();
//		BranchGroup zuK = construct();
		
		//TransformGroup用意
		TransformGroup tg = new TransformGroup();
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);		
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		//マウス云々。BoundingSphereにわらわらと。
		BoundingSphere bs = new BoundingSphere( new Point3d(), 10.0);
		
		MouseRotate rotM = new MouseRotate( tg );
		rotM.setSchedulingBounds( bs );
		Pri.addChild( rotM );
		
		MouseTranslate tranM = new MouseTranslate( tg );
		tranM.setSchedulingBounds( bs );
		Pri.addChild( tranM );
		
		MouseZoom zoomM = new MouseZoom( tg );
		zoomM.setSchedulingBounds( bs );
		Pri.addChild( zoomM );
		
		//TransformGroupをBranchGroupへ登録
//		tg.addChild(zuK);
		Pri.addChild(tg);

		univ.addBranchGraph( Pri );
	}
	
	//組立部
	BranchGroup construct(){
		BranchGroup bg = new BranchGroup();
		
		//Appearance設定
		Appearance app = new Appearance();
		app.setColoringAttributes(
                new ColoringAttributes(1.0f, 1.0f, 1.0f, ColoringAttributes.FASTEST));
		
		//Transform3D,TransformGroup複数作って各位図形登録。
		
		
		//TransformGroup登録
		for(int i=0; i<mt.length; i++){
			if(mt[i] == null){break;}
			bg.addChild(mt[i]);
		}
		bg.compile();
		return bg;
	}
	
	//ポリゴン。BGもらって登録して返す。
	BranchGroup polyTriPole( BranchGroup bg, int len ){
		
		
		return bg;
	}
	
	
	
	//ウィンドウ
	public static void main(String args[]){
		Es5 es5 = new Es5();
		
		//サイズ設定
		es5.setBounds( 0, 0, 600, 600 );
		
		//終了処理
		es5.addWindowListener( 
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}
			);

		es5.setVisible( true );
	}
}
