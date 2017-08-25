package teste.com.br.teste;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class Helper {

    public static void toast(Context ctx, String mensagem){
        Toast.makeText(ctx, mensagem, Toast.LENGTH_SHORT).show();
    }

    public static void alertSimples(Context ctx, String titulo, String mensagem){
        AlertDialog.Builder alerta = new AlertDialog.Builder(ctx);
        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.show();
    }

    public static void alertButtons(Context ctx, String titulo, String mensagem, String txtBtnOk, DialogInterface.OnClickListener okDialog,  String txtBtnRecusar, DialogInterface.OnClickListener recusarDialog){
        AlertDialog.Builder alerta = new AlertDialog.Builder(ctx);
        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setPositiveButton(txtBtnOk, okDialog);
        alerta.setNegativeButton(txtBtnRecusar, recusarDialog);
        alerta.show();
    }
    
    //  HELPER PARA CARREGAR AS TELAS DE FRAGMENT
    public static void loadFragment(Fragment f, boolean addToBackStack, Bundle args, Activity activity) {
        f.setArguments(args);
        FragmentTransaction transaction = ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.main_fragment, f);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
    
    public static void loadToolbar(Toolbar toolbar, final Activity activity) {
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getFragmentManager().popBackStack();
            }
        });
    }

    public static void openClass(Context ctx, Class classe){
        ctx.startActivity(new Intent(ctx, classe));
    }
        
    public static void pushMessage(Activity a, int icon, @NonNull final Class classeIda, String titulo, String mensagem, Bitmap iconLarge) {
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(a)
                .setSmallIcon(icon)
                .setContentTitle(titulo)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setLargeIcon(iconLarge)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentText(mensagem);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(a);
        stackBuilder.addNextIntent(new Intent(a, Object.class));
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) a.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }
        
    public static void openWebPage(Context ctx, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(ctx.getPackageManager()) != null) {
            ctx.startActivity(intent);
        }
    }

    public static void callNumber(Context ctx, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone));
        if (intent.resolveActivity(ctx.getPackageManager()) != null) {
            ctx.startActivity(intent);
        }
    }

    public static void showMap(Uri geoLocation, Context ctx) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(ctx.getPackageManager()) != null) {
            ctx.startActivity(intent);
        }
    }
        
    public static void sendEmail(Context ctx, String endereco, String assunto){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, endereco);
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
        //  intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(ctx.getPackageManager()) != null) {
            ctx.startActivity(intent);
        }
    }
}
