package pe.edu.upeu.proyectofinal.formulas;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.stat.correlation.KendallsCorrelation;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.inference.*;

import java.util.ArrayList;
import java.util.List;

public class pruebaDeHipotesis {
    TTest tTest = new TTest();
    double[] grupo1 = {1.2, 1.5, 1.7};
    double[] grupo2 = {0.9, 1.0, 1.3};
    double[] antes = {10.5, 12.1, 9.8};
    double[] despues = {11.0, 12.5, 10.2};
    double[] x = {1.0, 2.0, 3.0, 4.0};
    double[] y = {1.5, 2.5, 3.5, 4.5};
    public static void main(String[] args) {
    }
    public void t_independiente(){

        double pValor = tTest.tTest(grupo1, grupo2);
        double tValor = tTest.t(grupo1, grupo2);
        System.out.println(pValor);
        System.out.println(tValor);
    }
    public void t_pareada(){
        double pValor = tTest.pairedTTest(antes, despues);
    }
    public void t_una_muestra(){
        double[] muestra = {15.3, 16.1, 14.9};
        double mediaTeorica = 15.0;
        double pValor = tTest.tTest(mediaTeorica, muestra);
    }
    public void u_mann(){
        MannWhitneyUTest uTest = new MannWhitneyUTest();
        double pValor = uTest.mannWhitneyUTest(grupo1, grupo2);
    }
    public void chi_cuadrado(){
        long[][] tabla = {{40, 30}, {20, 50}};
        ChiSquareTest chiTest = new ChiSquareTest();
        double pValor = chiTest.chiSquareTest(tabla);
    }
    public void anova_unidireccional(){
        List<double[]> grupos = new ArrayList<>();
        grupos.add(new double[]{10.1, 10.5, 9.8});
        grupos.add(new double[]{12.3, 11.9, 12.1});
        OneWayAnova anova = new OneWayAnova();
        double pValor = anova.anovaPValue(grupos);
    }
    public void binomial(){
        int exitos = 5;
        int ensayos = 10;
        double probTeorica = 0.5;
        BinomialDistribution binomial = new BinomialDistribution(ensayos, probTeorica);
        double pValor = 2 * binomial.cumulativeProbability(exitos);
    }
    public void wilcoxon(){
        WilcoxonSignedRankTest wilcoxon = new WilcoxonSignedRankTest();
        double pValor = wilcoxon.wilcoxonSignedRankTest(antes, despues, false);
    }
    public void pearson(){
        PearsonsCorrelation pearson = new PearsonsCorrelation();
        double correlacion = pearson.correlation(x, y);
    }
    public void spearman(){
        SpearmansCorrelation spearman = new SpearmansCorrelation();
        double correlacion = spearman.correlation(x, y);
    }
    public void rpb(){
        double[] y = {10.0, 12.0, 8.0, 15.0};
        int[] x = {0, 1, 0, 1};

        DescriptiveStatistics stats1 = new DescriptiveStatistics();
        DescriptiveStatistics stats0 = new DescriptiveStatistics();

        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1) stats1.addValue(y[i]);
            else stats0.addValue(y[i]);
        }

        double mean1 = stats1.getMean();
        double mean0 = stats0.getMean();
        double n1 = stats1.getN();
        double n0 = stats0.getN();
        double n = n1 + n0;

        DescriptiveStatistics statsY = new DescriptiveStatistics();
        for (double val : y) statsY.addValue(val);
        double sY = statsY.getStandardDeviation();

        double r_pb = ((mean1 - mean0) / sY) * Math.sqrt((n1 * n0) / (n * (n - 1)));
        System.out.println("Punto-Biserial r = " + r_pb);
    }
    public void tau(){
        KendallsCorrelation kendall = new KendallsCorrelation();
        double tau = kendall.correlation(x, y);
    }
    public void alpha(){
        double[][] items = {
                {5, 4, 5, 3},
                {4, 3, 4, 2},
                {3, 2, 3, 1}
        };

        int k = items.length;
        int n = items[0].length;

        DescriptiveStatistics varItems = new DescriptiveStatistics();
        double[] totalScores = new double[n];
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j < k; j++) {
                total += items[j][i];
            }
            totalScores[i] = total;
        }
        DescriptiveStatistics varTotal = new DescriptiveStatistics(totalScores);

        double sumVarItems = 0;
        for (double[] item : items) {
            DescriptiveStatistics stats = new DescriptiveStatistics(item);
            sumVarItems += stats.getVariance();
        }

        double alpha = (k / (k - 1.0)) * (1 - (sumVarItems / varTotal.getVariance()));
        System.out.println("Alfa de Cronbach: " + alpha);
    }
    public void kappa(){
        int[][] matriz = {
                {20, 5},
                {3, 10}
        };

        double total = matriz[0][0] + matriz[0][1] + matriz[1][0] + matriz[1][1];
        double po = (matriz[0][0] + matriz[1][1]) / total;

        double pe = (
                ((matriz[0][0] + matriz[0][1]) / total) * ((matriz[0][0] + matriz[1][0]) / total) +
                        ((matriz[1][0] + matriz[1][1]) / total) * ((matriz[0][1] + matriz[1][1]) / total)
        );

        double kappa = (po - pe) / (1 - pe);
        System.out.println("Kappa de Cohen: " + kappa);
    }
    public void w_kendall(){
        double[][] rankings = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3}
        };

        int k = rankings.length;
        int n = rankings[0].length;

        double[] sumRanks = new double[n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                sumRanks[j] += rankings[i][j];
            }
        }

        double sumRiSquared = 0;
        for (double r : sumRanks) {
            sumRiSquared += r * r;
        }

        double W = (12 * sumRiSquared - 3 * k * k * n * Math.pow(n + 1, 2)) /
                (k * k * n * (n * n - 1));

        System.out.println("W de Kendall: " + W);
    }
}

