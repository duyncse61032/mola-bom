package vn.edu.fpt.mola.bom.entity.view;

public interface EntityView<E>
{
    E toEntity();
    void updateEntity(E entity);
}
