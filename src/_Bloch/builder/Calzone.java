package _Bloch.builder;

public class Calzone extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder>{
        private boolean sauceInside;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }


        public Builder(boolean sauceInside) {
            this.sauceInside = sauceInside;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }
    }

    public Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
