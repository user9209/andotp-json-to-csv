package de.cryptosdk.data.json.totp;

import java.io.Serializable;
import java.util.Arrays;

public class TotpEntry implements Serializable {

    private static String separator = "\t";

    public static void setSeparator(String separator) {
        TotpEntry.separator = separator;
    }

    public static String getSeparator() {
        return separator;
    }

    protected String secret;
    protected String issuer;
    protected String label;
    protected int digits;

    protected String type;
    protected String algorithm;
    protected String thumbnail;
    protected long last_used;
    protected int used_frequency;
    protected int period;
    protected String[] tags;

    public TotpEntry() {
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getLast_used() {
        return last_used;
    }

    public void setLast_used(long last_used) {
        this.last_used = last_used;
    }

    public int getUsed_frequency() {
        return used_frequency;
    }

    public void setUsed_frequency(int used_frequency) {
        this.used_frequency = used_frequency;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public static String csvTitle() {
        return "Label" + separator + "Secret" + separator + "Info";
    }
    public String toCSV() {
        return
            label +
            separator +
            secret +
            separator +
            type + " " + algorithm + " " + digits + " " + period + "s"
            ;
    }

    @Override
    public String toString() {
        return "TotpEntry{" +
                "secret='" + secret + '\'' +
                ", issuer='" + issuer + '\'' +
                ", label='" + label + '\'' +
                ", digits=" + digits +
                ", type='" + type + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", last_used=" + last_used +
                ", used_frequency=" + used_frequency +
                ", period=" + period +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
