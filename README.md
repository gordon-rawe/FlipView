# FlipView

This flip view library is very simple to use, in fact what we care is just to add two views as the upside and the downside, and maybe we want to specify the flip time or the flip direction.

Ok let me show you how to use it the simplest way:

```java
public class FlipView extends AbstractFlipView {

    public FlipView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View getUpSideView() {
        View oneSide = LayoutInflater.from(getContext()).inflate(R.layout.layout_one_side, this, false);
        oneSide.findViewById(R.id.image).setBackgroundColor(Color.RED);
        return oneSide;
    }

    @Override
    protected View getDownSideView() {
        View oneSide = LayoutInflater.from(getContext()).inflate(R.layout.layout_one_side, this, false);
        oneSide.findViewById(R.id.image).setBackgroundColor(Color.GREEN);
        return oneSide;
    }
}
```

First write a class that extends AbstractFlipView, and implement the getUpSideView() and the getDownSideView() methods, which will tell the container to use which view to render, to specify the direction.
just use setDirection(Direction direction) method.
```java
public FlipView(Context context, AttributeSet attrs) {
    super(context, attrs);
    setDirection(Direction.CLOCK_WISE);
}
```

and maybe you want to specify the elapse time, I will give this interface later..., or you can read the code and change it in the xml.