package org.antlr.intellij.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class STv4FileType extends LanguageFileType {
	public static final STv4FileType INSTANCE = new STv4FileType();

	private STv4FileType() {
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
		return Icons.ST_FILE;
	}
}
