public class CC {
    private boolean overflow;
    private boolean underflow;
    private boolean divzero;
    private boolean equalornot;

    CC() {
        this.overflow = false;
        this.underflow = false;
        this.divzero = false;
        this.equalornot = false;
    }
    public void setOverflow(boolean overflow) {
        this.overflow = overflow;
    }
    public boolean getOverflow() {
        return this.overflow;
    }
    public void setUnderflow(boolean underflow) {
        this.underflow = underflow;
    }
    public boolean getUnderflow() {
        return this.underflow;
    }
    public void setDivzero(boolean divzero) {
        this.divzero = divzero;
    }
    public boolean getDivzero() {
        return this.divzero;
    }
    public void setEqualornot(boolean equalornot) {
        this.equalornot = equalornot;
    }
    public boolean getEqualornot() {
        return this.equalornot;
    }
    public boolean getValueByPlace(int index) {
        boolean result = false;
        switch(index) {
            case 0:
                result = this.overflow;
                break;
            case 1:
                result = this.underflow;
                break;
            case 2:
                result = this.divzero;
                break;
            case 3:
                result = this.equalornot;
                break;
        }
        return result;
    }
}
