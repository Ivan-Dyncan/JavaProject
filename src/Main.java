import org.jfree.ui.RefineryUtilities;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var a = new GetDataFromCSV("Спорт.csv");
        var parsData = new ArrayList<DataClass>();
        for (var i = 0; i<a.rows.size(); i++) {
            if (a.rows.get(i).split(";").length==8)
                parsData.add(new DataClass(a.rows.get(i)));
        }

        SqlLiteConnection.Conn();
        SqlLiteConnection.CreateDB();
        //SqlLiteConnection.WriteDB(parsData); //раскоментируйте, чтобы переписать данные таблицы (не рекомендуется)
        //SqlLiteConnection.ReadDB(); //раскоментируйте, чтобы вывести часть таблицы

        // 1ое задание
        Chart chart = new Chart(SqlLiteConnection.FirstTask(),"Диаграмма",
                "Участники/Виды спорта");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);

        // 2ое задание
        //SqlLiteConnection.SecondTask();


        // 3е задание
        //SqlLiteConnection.ThirdTask();
        SqlLiteConnection.CloseDB();

    }
}
