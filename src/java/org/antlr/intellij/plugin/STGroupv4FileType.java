package org.antlr.intellij.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class STGroupv4FileType extends LanguageFileType {
	public static final STGroupv4FileType INSTANCE = new STGroupv4FileType();

	private STGroupv4FileType() {
		super(STv4Language.INSTANCE);
	}

	@NotNull
	@Override
	public String getName() {
		return "StringTemplate v4 template group file";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "StringTemplate v4 template group file";
	}

	@NotNull
	@Override
	public String getDefaultExtension() {
		return "stg";
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return Icons.STG_FILE;
	}
}
