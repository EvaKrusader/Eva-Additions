// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelNightVision<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "nightvision"), "main");
	private final ModelPart bone;

	public ModelNightVision(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, -6.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.0F, -6.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 6)
						.addBox(-4.0F, -6.0F, -4.1F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(8, 2)
						.addBox(4.0F, -6.0F, -4.1F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(8, 10)
						.addBox(-4.0F, -6.0F, 3.9F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(8, 6)
						.addBox(-4.0F, -6.0F, -4.1F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bone.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone.xRot = headPitch / (180F / (float) Math.PI);
	}
}